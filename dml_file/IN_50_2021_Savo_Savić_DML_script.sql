-- Popunjavanje tabele grad
INSERT INTO grad (id_gr, naz_gr) VALUES (1, 'Beograd');
INSERT INTO grad (id_gr, naz_gr) VALUES (2, 'Novi Sad');
INSERT INTO grad (id_gr, naz_gr) VALUES (3, 'Subotica');
INSERT INTO grad (id_gr, naz_gr) VALUES (4, 'Niš');

DROP TABLE grad;

-- Popunjavanje tabele adresa
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (1, 'Kralja Petra 1', 1, 1);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (2, 'Nemanjina 4', 4, 1);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (3, 'Terazije 23', 23, 1);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (4, 'Bulevar Oslobođenja 20', 2, 2);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (5, 'Futoška 45', 45, 2);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (6, 'Trg Slobode 10', 10, 3);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (7, 'Cara Dušana 10', 3, 4);
INSERT INTO adresa (id_adr, ul_adr, rbr_adr, grad_id_gr) VALUES (8, 'Nikole Pašića 5', 5, 4);

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

-- Popunjavanje tabele stanodavac
INSERT INTO stanodavac (id_kor, ocena_stanod) VALUES (1, 4.5);

-- Popunjavanje tabele zakupac sa preferencijama za cimere
INSERT INTO zakupac (id_kor, pref_zak) VALUES (2, 'Nepušač, nema ljubimce, preferira mirnu okolinu.');

-- Popunjavanje tabele stan sa 2 stana
INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (1, 50, 35000, 4.5, 'DA', 1, 3, 2, 1);  -- Dvosoban stan sa osnovnim nameštajem

INSERT INTO stan (id_st, povr_st, cena_st, ocena_st, dostup_st, adresa_id_adr, kategorija_id_kat, opremljenost_id_opr, stanodavac_id_kor) 
VALUES (2, 75, 60000, 5.0, 'DA', 4, 4, 3, 1);  -- Višesoban stan sa kompletno opremljenim nameštajem

-- Popunjavanje tabele prostorija
-- Stan 1: Dvosoban stan
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (1, 'Dnevna soba', 25, 1);  -- Dnevna soba
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (2, 'Spavaća soba', 15, 1);  -- Spavaća soba

-- Stan 2: Višesoban stan
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (3, 'Dnevna soba', 30, 2);  -- Dnevna soba
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (4, 'Spavaća soba', 20, 2);  -- Spavaća soba
INSERT INTO prostorija (id_pros, naz_pros, povr_pros, stan_id_st) VALUES (5, 'Radna soba', 25, 2);  -- Radna soba
