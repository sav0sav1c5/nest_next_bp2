package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.service.StanService;

public class JednostavanUpit1UIHandler {

    private static final StanService stanService = new StanService();
    public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        System.out.println("\n[JEDNOSTAVAN UPIT 1]");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Opis: Prikazuje prosečne cene stanova po kategorijama.                              |");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Upit: SELECT k.naz_kat, AVG(s.cena_st) AS prosecna_cena                             |");
        System.out.println("|      FROM stan s                                                                   |");
        System.out.println("|      JOIN kategorija k ON s.kategorija_id_kat = k.id_kat                           |");
        System.out.println("|      GROUP BY k.naz_kat                                                            |");
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
        System.out.println("\nProsečne cene stanova po kategorijama:");
        
        try {
            Map<String, Double> avgPrices = stanService.getAveragePriceByCategory();
        	System.out.println(" _________________________________________");
            System.out.printf("| %-5s | %-15s | %-10s | %n", "Br.", "Kategorija", "Prosečna Cena");
            System.out.println(" -----------------------------------------");
            
            int i = 1;
            for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
                System.out.printf("| %-5d | %-15s | %-10.2f    | %n", i++, entry.getKey(), entry.getValue());
                System.out.println(" -----------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Greška prilikom izvršavanja upita: " + e.getMessage());
        }
    }
	
}
