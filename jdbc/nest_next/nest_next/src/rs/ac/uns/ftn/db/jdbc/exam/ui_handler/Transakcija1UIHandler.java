package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.dto.OglasavanjeDTO;
import rs.ac.uns.ftn.db.jdbc.exam.model.Adresa;
import rs.ac.uns.ftn.db.jdbc.exam.model.Grad;
import rs.ac.uns.ftn.db.jdbc.exam.model.Stan;
import rs.ac.uns.ftn.db.jdbc.exam.service.GradService;
import rs.ac.uns.ftn.db.jdbc.exam.service.OglasavanjeService;

public class Transakcija1UIHandler {

    private OglasavanjeService oglasavanjeService = new OglasavanjeService();
    private GradService gradService = new GradService();
    public static Scanner sc = new Scanner(System.in);

    public void handleUpit() {
        System.out.println("\n[TRANSAKCIJA 1]");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|Opis: Prikazuje proces oglašavanja stana od strane stanodavca. U procesu oglašavanja |");
        System.out.println("|      se prvo odabere grad u kome se stan nalazi, zatim dodaju podaci o adresi tj.   |");
        System.out.println("|      ulica i redni broj i nakon toga podaci potrebni za oglašavanje stana.          |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|Upit: INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr)                       |");
        System.out.println("|      VALUES (?, ?, ?, ?)                                                            |");
        System.out.println("|      INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, |");
        System.out.println("|      kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor)                     |");
        System.out.println("|      VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);                                            |");
        System.out.println("---------------------------------------------------------------------------------------");
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
        try {
            // Izlistavanje svih gradova sa imenima
            System.out.println("\nDostupni gradovi:");
            for (Grad grad : gradService.getAll()) {
                System.out.println(grad.getNazivGr());
            }

            System.out.print("\nUnesite ime grada: ");
            String nazivGrada = sc.nextLine();

            // Provera da li grad postoji u bazi
            int gradId = -1;
            for (Grad grad : gradService.getAll()) {
                if (grad.getNazivGr().equalsIgnoreCase(nazivGrada)) {
                    gradId = grad.getIdGr();
                    System.out.println("Odabrano: " + grad.getNazivGr());
                    break;
                }
            }

            if (gradId == -1) {
                System.out.println("Grad nije pronađen. Molimo izaberite jedan od dostupnih gradova.");
                return;
            }

            // Unos podataka za adresu
            System.out.print("Unesite ulicu: ");
            String ulAdr = sc.nextLine();

            System.out.print("Unesite broj: ");
            int rbrAdr = Integer.parseInt(sc.nextLine());
            
            // Kreiranje objekta Adresa
            Adresa novaAdresa = new Adresa();
            novaAdresa.setUlAdr(ulAdr);
            novaAdresa.setRbrAdr(rbrAdr);
            novaAdresa.setGradIdGr(gradId);

            // Unos podataka za stan
            System.out.print("Unesite površinu stana: ");
            int povrSt = Integer.parseInt(sc.nextLine());

            System.out.print("Unesite cenu stana: ");
            int cenaSt = Integer.parseInt(sc.nextLine());

            System.out.print("Unesite ocenu stana (1-5): ");
            float ocenaSt = Float.parseFloat(sc.nextLine());

            System.out.print("Da li je stan dostupan (DA/NE): ");
            String dostupSt = sc.nextLine();

            // Kreiranje objekta Stan
            Stan noviStan = new Stan();
            noviStan.setPovrSt(povrSt);
            noviStan.setCenaSt(cenaSt);
            noviStan.setOcenaSt(ocenaSt);
            noviStan.setDostupSt(dostupSt);
            // U principu trebalo bi se i za njih uraditi isto ono što je i za
            // adresu i stan, unos podataka, a posle insertovanje (specifikacija kaze min 2 insert, update ili delete).
            // Sem ako ne dodje do nekih promena zahteva projekta naredne 4 linije mogu 
            // ostati fiksirane.
            noviStan.setAdresaIdAdr(0); // Placeholder za ID adrese (biće generisan nakon unosa)
            noviStan.setKategorijaIdKat(2); // Primer kategorije
            noviStan.setOpremljenostIdOpr(1); // Primer opremljenosti
            noviStan.setStanodavacIdKor(1); // Primer stanodavca

            // Kreiranje DTO objekta
            OglasavanjeDTO oglasavanjeDTO = new OglasavanjeDTO(novaAdresa, noviStan);

            // Poziv servisa za transakciju
            boolean uspeh = oglasavanjeService.insertOglasavanje(oglasavanjeDTO);

            if (uspeh) {
                System.out.println("Uspešno izvršena transakcija unosa adrese i stana.");
            } else {
                System.out.println("Došlo je do greške tokom unosa.");
            }
            
        } catch (SQLException e) {
            System.out.println("Greška prilikom izvršavanja unosa: " + e.getMessage());
        }
    }
}
