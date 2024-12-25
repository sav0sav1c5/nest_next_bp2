# Projekat iz Baza Podataka 2 (BP2) - Specifikacija i Implementacija

Ovaj repozitorijum sadrži implementaciju projekta BP2 prema dostavljenoj specifikaciji.

## Sadržaj

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

- `model/` - Definicija EER modela i relacionog modela.
- `scripts/` - Generisane DDL i DML skripte.
- `src/` - Izvorni kod aplikacije organizovan po slojevima:
  - `dao/` - Data Access Object sloj.
  - `service/` - Servisni sloj.
  - `uihandler/` - Interfejs korisnika.
  - `dto/` - Data Transfer Object klase.

## Pokretanje Projekta

1. Klonirajte repozitorijum:
   ```bash
   git clone <repo_url>
   ```
2. Kreirajte bazu podataka koristeći DDL skripte iz foldera `scripts/`.
3. Popunite tabele koristeći DML skripte.
4. Pokrenite aplikaciju iz foldera `src/` koristeći omiljeni IDE.

## Autor

Projekat izrađen kao deo zadatka na BP2 kursu.

