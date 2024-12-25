package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.dto.GradoviIBrojStanovaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.service.GradService;

public class JednostavanUpit2UIHandler {

	private static final GradService gradService = new GradService();
	public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        System.out.println("\n[JEDNOSTAVAN UPIT 2]");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Opis: Prikazuje ukupan broj oglašenih stanova u svakom gradu.                       |");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Upit: SELECT g.ime_grada, COUNT(s.stan_id) AS broj_stanova                          |");
        System.out.println("|      FROM grad g                                                                   |");
        System.out.println("|      JOIN adresa a ON g.grad_id = a.grad_id                                        |");
        System.out.println("|      JOIN stan s ON a.adresa_id = s.adresa_id                                      |");
        System.out.println("|      GROUP BY g.ime_grada;                                                         |");
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
        System.out.println("\nUkupan broj oglašenih stanova po gradovima:");
        
        try {
            List<GradoviIBrojStanovaDTO> stanoviPoGradovima = gradService.getGradoviIBrojStanova();
            System.out.println(" _____________________________________________");
            System.out.printf("| %-5s | %-20s | %-10s | %n", "Br.", "Grad", "Broj Stanova");
            System.out.println(" ---------------------------------------------");

            int i = 1;
            // Iteriramo kroz listu GradoviIBrojStanovaDTO objekata
            for (GradoviIBrojStanovaDTO entry : stanoviPoGradovima) {
                // Pozivamo getter metode na DTO objektu
                System.out.printf("| %-5d | %-20s | %-10d   | %n", i++, entry.getNazivGr(), entry.getBrojSt());
                System.out.println(" ---------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Greška prilikom izvršavanja upita: " + e.getMessage());
        }
    }
	
}
