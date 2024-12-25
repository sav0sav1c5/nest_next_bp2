package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.util.Scanner;

public class Transakcija2UIHandler {

    public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        System.out.println("\n[TRANSAKCIJA 2]");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|Opis:                                                                                |");
        //System.out.println("|Opis: Prikazuje proces oglašavanja stana od strane stanodavca. U procesu oglašavanja |");
        //System.out.println("|      se prvo odabere grad u kome se stan nalazi, zatim dodaju podaci o adresi tj.   |");
        //System.out.println("|      ulica i redni broj i nakon toga podaci potrebni za oglašavanje stana.          |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|Upit:                                                                                |");
        //System.out.println("|Upit: INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr)                       |");
        //System.out.println("|      VALUES (?, ?, ?, ?)                                                            |");
        //System.out.println("|      INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, |");
        //System.out.println("|      kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor)                     |");
        //System.out.println("|      VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);                                            |");
        System.out.println("---------------------------------------------------------------------------------------1");
        System.out.println("Odaberite:");
        System.out.println("  [1]  POTVRDI pokretanje upita");
        System.out.println("  [0]  Nazad");
        
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("1")) {
            executeQuery();
        } else if (answer.equalsIgnoreCase("X")) {
            System.out.println("Unos je prekinut.");
        } else {
            System.out.println("Nepoznata opcija!");
        }
    }

    private void executeQuery() {
    
    	
    	
    	
    }
}
