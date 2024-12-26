package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;

public class MainUIHandler {

	public static Scanner sc = new Scanner(System.in);

    public void handleMainMenu() {
        
        System.out.println("Testing HikariCP connection..."); // Testiranje konekcije pre glavnog menija

        try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {

        	if (connection != null) {
        		System.out.println("Successfully connected to the database!");

                try (Statement stmt = connection.createStatement()) { // Primer upita za testiranje konekcije
                	ResultSet rs = stmt.executeQuery("SELECT 1 FROM DUAL");
                    
                	if (rs.next()) {
                		System.out.println("Test query executed successfully, result: " + rs.getInt(1));
                	}
                }
            
        	} else {
        		System.out.println("Failed to establish a connection.");
                return; // Prekid ako nema konekcije
        	}
        
        } catch (Exception e) {
        	System.err.println("An error occurred while testing the connection:");
            e.printStackTrace();
            return; // Prekid u slučaju greške
        } 

        String answer;

        do {
        	System.out.println("\n\n           ==============================");
        	System.out.println("          |            MENU              |");
        	System.out.println("           ==============================");
            System.out.println("          | Odaberite opciju:            |");
            System.out.println("          |   [1]  Osnovni upit          |");
            System.out.println("          |   [2]  Jednostavan upit 1    |");
            System.out.println("          |   [3]  Jednostavan upit 2    |");
            System.out.println("          |   [4]  Kompleksan upit       |");
            System.out.println("          |   [5]  Transakcija           |");
            System.out.println("          |   [X]  Izlazak iz programa   |");
            System.out.println("          |                              |");
            System.out.println("           ==============================");
            System.out.println("\nVaš odabir:");
            
            answer = sc.nextLine();

            switch (answer) {
                case "1":
                    new OsnovniUpitUIHandler().handleUpit();
                    break;
                case "2":
                    new JednostavanUpit1UIHandler().handleUpit();
                    break;
                case "3":
                    new JednostavanUpit2UIHandler().handleUpit();
                    break;
                case "4":
                    new KompleksanUpitUIHandler().handleUpit();
                    break;
                case "5":
                    new TransakcijaUIHandler().handleUpit();
                    break;
                case "X":
                    ConnectionUtil_HikariCP.closeDataSource();
                    System.out.println("HikariCP DataSource closed.");
                    System.out.println("### Exiting application...");
                	break;
                case "x":
                    ConnectionUtil_HikariCP.closeDataSource();
                    System.out.println("HikariCP DataSource closed.");
                    System.out.println("### Exiting application...");
                	break;
                default:
                    System.out.println("Nepoznata opcija!");
            }

        } while (!answer.equalsIgnoreCase("X"));

        sc.close();
    }

}
