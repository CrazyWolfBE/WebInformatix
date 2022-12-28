CREATE TABLE IF NOT EXISTS mangas (
    id_manga SERIAL PRIMARY KEY,
    nom varchar(32),
    nb_tome integer,
    auteur varchar(15),
    date_sortie date,
    synopsis varchar(1000),
    price float,
    shop boolean
    );