package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.dto.NajcesceKategorijeStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.service.GradService;

public class KompleksanUpitUIHandler {

	private static final GradService gradService = new GradService();
	public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        System.out.println("\n[KOMPLEKSAN UPIT]");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Opis: Prikazuje gradove sa najčešćim kategorijama stanova.                          |");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Upit: SELECT g.naz_gr, k.naz_kat, COUNT(s.id_st) AS brojStanova                     |");
        System.out.println("|      FROM grad g                                                                   |");
        System.out.println("|      JOIN adresa a ON g.id_gr = a.grad_id_gr                                       |");
        System.out.println("|      JOIN stan s ON a.id_adr = s.adresa_id_adr                                     |");
        System.out.println("|      JOIN kategorija k ON s.kategorija_id_kat = k.id_kat                           |");
        System.out.println("|      GROUP BY g.naz_gr, k.naz_kat                                                  |");
        System.out.println("|      ORDER BY brojStanova DESC                                                     |");
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
        try {
            List<NajcesceKategorijeStanovaDTO> gradovi = gradService.getNajcesceKategorijeStanova();
            System.out.println("\nGradovi sa najčešćim kategorijama stanova:");
            System.out.println(" ____________________________________________________________________________");
            System.out.printf("| %-5s | %-20s | %-25s | %-15s | %n", "Br.", "Grad", "Najčešća Kategorija", "Broj Stanova");
            System.out.println(" ----------------------------------------------------------------------------");
            
            int i = 1;
            
            for (NajcesceKategorijeStanovaDTO grad : gradovi) {
            	System.out.printf("| %-5d | %-20s | %-25s | %-15d | %n", i++, grad.getNazivGr(), grad.getNazivKat(), grad.getBrojStanova());
            	System.out.println(" ----------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
