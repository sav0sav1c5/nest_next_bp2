package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.model.Grad;
import rs.ac.uns.ftn.db.jdbc.exam.service.GradService;

public class OsnovniUpitUIHandler {

    private static final GradService gradService = new GradService();
    public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        System.out.println("\n[OSNOVNI UPIT]");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Opis: Prikazuje sve gradove iz baze podataka.                                       |");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Upit: SELECT id_gr, naz_gr                                                          |");
        System.out.println("|      FROM grad                                                                     |");
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
        System.out.println("\nPrikaz svih gradova gde potencijalno možete pronaći stan:");
        // Ručno formatiranje zaglavlja
        System.out.println(" ______________________________");
        System.out.printf("| %-5s | %-20s | %n", "Br.", "Grad");
        System.out.println(" ------------------------------");

        int br = 1;
        
        try {
            for (Grad grad : gradService.getAll()) {
            	System.out.printf("| %-5s | %-20s | %n", br++, grad.getNazivGr());
            	System.out.println(" ------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Greška prilikom izvršavanja upita: " + e.getMessage());
        }
    }
    
}
