-- Popunjavanje tabele grad
INSERT INTO grad (id_gr, naz_gr) VALUES (1, 'Beograd');
INSERT INTO grad (id_gr, naz_gr) VALUES (2, 'Novi Sad');
INSERT INTO grad (id_gr, naz_gr) VALUES (3, 'Subotica');
INSERT INTO grad (id_gr, naz_gr) VALUES (4, 'Niš');

-- Popunjavanje tabele adresa
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (1, 'Kralja Petra 1', 1, 1);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (2, 'Nemanjina 4', 4, 1);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (3, 'Terazije 23', 23, 1);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (4, 'Bulevar Oslobođenja 20', 2, 2);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (5, 'Futoška 45', 45, 2);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (6, 'Trg Slobode 10', 10, 3);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (7, 'Cara Dušana 10', 3, 4);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (8, 'Nikole Pašića 5', 5, 4);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (9, 'Bulevar Mihajla Pupina 10', 10, 2);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (10, 'Ulica Kralja Aleksandra 50', 50, 1);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (11, 'Bulevar Kralja Petra 30', 30, 1);

-- Popunjavanje tabele kategorija
INSERT INTO kategorija (id_kat, naz_kat) VALUES (1, 'Garsonjera');
INSERT INTO kategorija (id_kat, naz_kat) VALUES (2, 'Jednosoban');
INSERT INTO kategorija (id_kat, naz_kat) VALUES (3, 'Dvosoban');
INSERT INTO kategorija (id_kat, naz_kat) VALUES (4, 'Višesoban');

-- Popunjavanje tabele opremljenost
INSERT INTO opremljenost (id_opr, nivo_opr, opis_opr) VALUES (1, 'Neopremljen', 'Stan bez nameštaja i uređaja.');
INSERT INTO opremljenost (id_opr, nivo_opr, opis_opr) VALUES (2, 'Poluopremljen', 'Stan sa osnovnim nameštajem i aparatom.');
INSERT INTO opremljenost (id_opr, nivo_opr, opis_opr) VALUES (3, 'Kompletno opremljen', 'Stan sa modernim nameštajem i svim potrebnim uređajima.');

-- Popunjavanje tabele korisnik
INSERT INTO korisnik (id_kor, ime_kor, prz_kor, email_kor, tip_kor, korisnik_type) 
VALUES (1, 'Marko', 'Markovic', 'marko@mail.com', 'Stanodavac', 'Stanodavac');
INSERT INTO korisnik (id_kor, ime_kor, prz_kor, email_kor, tip_kor, korisnik_type) 
VALUES (2, 'Jelena', 'Jovanovic', 'jelena@mail.com', 'Zakupac', 'Zakupac');
INSERT INTO korisnik (id_kor, ime_kor, prz_kor, email_kor, tip_kor, korisnik_type) 
VALUES (3, 'Ana', 'Nikolic', 'ana@mail.com', 'Stanodavac', 'Stanodavac');
INSERT INTO korisnik (id_kor, ime_kor, prz_kor, email_kor, tip_kor, korisnik_type) 
VALUES (4, 'Petar', 'Petrovic', 'petar@mail.com', 'Stanodavac', 'Stanodavac');

-- Popunjavanje tabele stanodavac
INSERT INTO stanodavac (id_kor, ocena_stanod) VALUES (1, 4.5);
INSERT INTO stanodavac (id_kor, ocena_stanod) VALUES (3, 4.8);
INSERT INTO stanodavac (id_kor, ocena_stanod) VALUES (4, 4.7);

-- Popunjavanje tabele zakupac sa preferencijama za cimere
INSERT INTO zakupac (id_kor, pref_zak) VALUES (2, 'Nepušač, nema ljubimce, preferira mirnu okolinu.');

-- Popunjavanje tabele stan
-- Stan 1: Dvosoban stan (Marko)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (1, 50, 35000, 4.5, 'DA', 1, 3, 2, 1);
-- Stan 2: Višesoban stan (Marko)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (2, 75, 60000, 5.0, 'DA', 4, 4, 3, 1); 
-- Stan 3: Višesoban stan (Ana)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (3, 85, 70000, 4.9, 'DA', 5, 4, 3, 3);
-- Stan 4: Višesoban stan (Petar)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (4, 90, 75000, 4.6, 'DA', 6, 4, 3, 4);
-- Stan 5: Dvosoban stan (Ana)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (5, 60, 40000, 4.7, 'DA', 2, 3, 2, 3);
-- Stan 6: Jednosoban stan (Petar)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (6, 40, 30000, 4.3, 'DA', 3, 2, 2, 4);
-- Stan 7: Višesoban stan (Petar)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (7, 100, 85000, 4.8, 'DA', 9, 4, 3, 1);
-- Stan 8: Višesoban stan (Petar)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (8, 95, 80000, 4.6, 'DA', 10, 4, 3, 4); 
-- Stan 9: Garsonjera (Petar)
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (9, 30, 25000, 4.2, 'DA', 11, 1, 2, 4);

-- Popunjavanje tabele prostorija
-- Stan 1: Dvosoban stan (Marko)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (1, 'Dnevna soba', 25, 1);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (2, 'Spavaća soba', 15, 1);
-- Stan 2: Višesoban stan (Marko)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (3, 'Dnevna soba', 30, 2);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (4, 'Spavaća soba', 20, 2);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (5, 'Radna soba', 25, 2);
-- Stan 3: Višesoban stan (Ana)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (6, 'Dnevna soba', 30, 3);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (7, 'Spavaća soba', 25, 3);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (8, 'Radna soba', 20, 3);
-- Stan 4: Višesoban stan (Petar)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (9, 'Dnevna soba', 35, 4);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (10, 'Spavaća soba', 30, 4);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (11, 'Trpezarija', 25, 4);
-- Stan 5: Dvosoban stan (Ana)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (12, 'Dnevna soba', 30, 5);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (13, 'Spavaća soba', 20, 5);
-- Stan 6: Jednosoban stan (Petar)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (14, 'Dnevna soba', 25, 6);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (15, 'Kuhinja', 15, 6);
-- Stan 7: Višesoban stan (Marko)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (16, 'Dnevna soba', 35, 7);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (17, 'Spavaća soba', 25, 7);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (18, 'Radna soba', 20, 7);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (19, 'Trpezarija', 20, 7);
-- Stan 8: Višesoban stan (Petar)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (20, 'Dnevna soba', 30, 8);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (21, 'Spavaća soba', 25, 8);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (22, 'Radna soba', 20, 8);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (23, 'Trpezarija', 20, 8);
-- Stan 9: Garsonjera (Petar)
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (24, 'Dnevna soba', 25, 9);
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (25, 'Kuhinja', 5, 9);
