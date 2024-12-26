# Projekat iz Baza Podataka 2 (BP2) - Specifikacija i Implementacija

## Opis

Ovaj repozitorijum sadrži kompletan materijal vezan za izradu projekta. U sklopu projekta nalazi se specifikacija sa opisom informacionog sistema, razvijen EER model koji je zatim preveden u relacioni model, fajlovi Data Modeler-a, DDL skriptu generisanu pomoću Data Modeler-a, DML skriptu za unos podataka i fajlove JDBC aplikacije. Projekat pruža praktično iskustvo u radu sa bazama podataka, SQL upitima i kroz implementaciju slojevite arhitekture.

## Specifikacije projekta

1. **Specifikacija Projekta**
   - Projekat odbranjen na KT1.

2. **EER Model**
   - EER dijagram izrađen korišćenjem Oracle Data Modeler-a.
   - Prevođenje EER modela u relacioni model ručno.
   - Generisanje DDL skripti za kreiranje baze podataka.

3. **Implementacija Šeme Baze Podataka**
   - Odabir 4-6 tabela koje će se koristiti za potrebe izveštaja.
   - Popunjavanje tabela smislenim podacima korišćenjem DML skripti.

4. **JDBC CLI Aplikacija**
   - Slojevita implementacija koristeći DAO, Service, UIHandler i DTO slojeve.
   - Izrada:
     - Jednostavnog upita: spajanje dve tabele sa upotrebom agregacionih funkcija.
     - Kompleksnih upita: spoljna spajanja 3-5 tabela sa filtriranjem, grupisanjem, i sortiranjem rezultata.
     - Transakcija: unos, modifikacija ili brisanje podataka u najmanje dve tabele.

## Struktura Projekta
- `data_modeler/` - Sadrži fajlove Data Modeler-a, kao i prikaz logičkog i relacionog modela.
- `ddl_file/` - Sadrži DDL skriptu generisanu pomoću Data Modeler-a za kreiranje baze podataka.
- `dml_file/` - Sadrži DML skriptu za unos podataka u bazu.
- `er/` - Sadrži fajlove koji prikazuju EER dijagram na osnovu kreirane specifikacije projekta.
- `jdbc/` - Izvorni kod aplikacije organizovan po slojevima:
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/connection/`** - Utility klase za konekciju sa bazom podataka.
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/dao/`** - Data Access Object (DAO) sloj.
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/dao/impl/`** - Implementacija Data Access Object (DAO) sloja.
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/dto/`** - Data Transfer Object (DTO) klase.
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/main/`** - Sadrži main klasu za pokretanje projekta.
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/model/`** - Model klase koje predstavljaju tabele u bazi podataka.
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/service/`** - Servisni sloj odgovoran za poslovnu logiku.
  - **`src/rs/ac/uns/ftn/db/jdbc/exam/ui_handler/`** - Klase koje upravljaju korisničkim interfejsom.
- `specification/` - Sadrži fajlove specifikaciju projekta.

## Pokretanje Projekta

1. Klonirajte repozitorijum:
   ```bash
   git clone <repo_url>
   ```
2. Kreirajte bazu podataka koristeći DDL skripte iz foldera `scripts/`.
3. Popunite tabele koristeći DML skripte.
4. Pokrenite aplikaciju iz foldera `src/` koristeći omiljeni IDE.

## Autor
**Savo Savić IN50/2021**

Projekat izrađen kao deo zadatka na BP2 kursu.

