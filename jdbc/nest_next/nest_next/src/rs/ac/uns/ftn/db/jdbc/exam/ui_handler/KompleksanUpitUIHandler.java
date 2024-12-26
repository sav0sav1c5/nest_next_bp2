package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.dto.NajcesceKategorijeStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.service.KompleksanUpitService;

public class KompleksanUpitUIHandler {

	private static final KompleksanUpitService kompleksanUputService = new KompleksanUpitService();
	public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        System.out.println("\n[KOMPLEKSAN UPIT]");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("| Opis: Ovaj složeniji upit daje broj stanova po gradovima i kategorijama. Spaja     |");
        System.out.println("|       tabele `grad`, `adresa`, `stan`, i `kategorija` kako bi dobio broj stanova u |");
        System.out.println("|       svakoj kombinaciji grada i kategorije. Pored toga, koristi funkciju          |");
        System.out.println("|       `SUM(COUNT(...))` u okviru `OVER (PARTITION BY ...)` za rangiranje           |");
        System.out.println("|       gradova prema ukupnom broju stanova, sortira rezultate po opadajućem         |");
        System.out.println("|       broju stanova, a zatim grupiše prema imenu grada i imenu kategorije.         |");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Upit: SELECT g.naz_gr, k.naz_kat, COUNT(s.id_st) AS brojStanova                     |");
        System.out.println("|      FROM grad g                                                                   |");
        System.out.println("|      JOIN adresa a ON g.id_gr = a.grad_id_gr                                       |");
        System.out.println("|      JOIN stan s ON a.id_adr = s.adresa_id_adr                                     |");
        System.out.println("|      JOIN kategorija k ON s.kategorija_id_kat = k.id_kat                           |");
        System.out.println("|      GROUP BY g.naz_gr, k.naz_kat                                                  |");
        System.out.println("|      ORDER BY SUM(COUNT(s.id_st)) OVER (PARTITION BY g.naz_gr) DESC, brojStanova   |");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Odaberite:");
        System.out.println("  [1]  POTVRDI pokretanje upita");
        System.out.println("  [0]  Nazad");
        
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("1")) {
            executeQuery();
        } else if (answer.equalsIgnoreCase("X")) {
            System.out.println("Upit je prekinut.");
        } else {
            System.out.println("Nepoznata opcija!");
        }
    }

    private void executeQuery() {
    	
    	System.out.println("\nGradovi sa najčešćim kategorijama stanova:");
    	System.out.println(NajcesceKategorijeStanovaDTO.getFormattedHeader());
    	
        try {
        	int br = 1;
        	String prethodniGrad = "";
            for (NajcesceKategorijeStanovaDTO najcesceKategorijeStanovaDTO : kompleksanUputService.getNajcesceKategorijeStanova()) {
            	
            	if (!najcesceKategorijeStanovaDTO.getNazivGr().equals(prethodniGrad)) {
            		System.out.printf("| %-5d %s%n", br++, najcesceKategorijeStanovaDTO.toString());
            	} else {
            		System.out.printf("|       %s%n", najcesceKategorijeStanovaDTO.toString());
            	}
            	
            	prethodniGrad = najcesceKategorijeStanovaDTO.getNazivGr();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
/*    
    private void executeQuery() {
        System.out.println("\nGradovi sa najčešćim kategorijama stanova:");
        System.out.println(NajcesceKategorijeStanovaDTO.getFormattedHeader());

        try {
            int br = 1;
            // Mapiranje gradova sa svim kategorijama
            Map<String, List<NajcesceKategorijeStanovaDTO>> gradKategorijeMap = new HashMap<>();

            // Grupisanje podataka po gradovima
            for (NajcesceKategorijeStanovaDTO kategorija : kompleksanUputService.getNajcesceKategorijeStanova()) {
                gradKategorijeMap.computeIfAbsent(kategorija.getNazivGr(), k -> new ArrayList<>()).add(kategorija);
            }

            // Ispisivanje podataka po gradovima
            for (Map.Entry<String, List<NajcesceKategorijeStanovaDTO>> entry : gradKategorijeMap.entrySet()) {
                String grad = entry.getKey();
                List<NajcesceKategorijeStanovaDTO> kategorije = entry.getValue();
                StringBuilder formatted = new StringBuilder();

                // Dodajemo sve kategorije za taj grad u string
                for (NajcesceKategorijeStanovaDTO kategorija : kategorije) {
                	formatted.append(kategorija.getNazivKat()).append(" (").append(kategorija.getBrojStanova()).append("), ");
                }

                // Uklanjamo poslednji zarez i razmak
                formatted.setLength(formatted.length() - 2);

                // Ispisivanje u željenom formatu sa poravnanjem
                System.out.printf("| %-5d | %-20s | %-60s    |%n", br++, grad, formatted.toString());
                System.out.println(" ------------------------------------------------------------------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

*/ 
   
}
