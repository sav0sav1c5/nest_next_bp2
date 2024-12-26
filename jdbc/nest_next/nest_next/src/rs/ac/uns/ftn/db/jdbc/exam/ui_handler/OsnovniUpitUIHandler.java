package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.dto.GradDTO;
import rs.ac.uns.ftn.db.jdbc.exam.service.GradService;

public class OsnovniUpitUIHandler {

    private static final GradService gradService = new GradService();
    public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        
    	System.out.println("\n[OSNOVNI UPIT]");
        System.out.println("======================================================================================");
        System.out.println("| Opis: Prikazuje sve gradove iz baze podataka (u kojima su izdavani stanovi).       |");
        System.out.println("======================================================================================");
        System.out.println("| Upit: SELECT id_gr, naz_gr                                                         |");
        System.out.println("|       FROM grad                                                                    |");
        System.out.println("======================================================================================");
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
        	
    	System.out.println("\nPrikaz svih gradova gde potencijalno možete pronaći stan:");
        System.out.println(GradDTO.getFormattedHeader());
        
        try {
        	int br = 1;
            for (GradDTO gradDTO : gradService.getAll()) {
            	System.out.printf("| %-5d %s%n", br++, gradDTO.toString());
            }
        } catch (SQLException e) {
            System.out.println("Greška prilikom izvršavanja upita: " + e.getMessage());
        }
    }
    
}
