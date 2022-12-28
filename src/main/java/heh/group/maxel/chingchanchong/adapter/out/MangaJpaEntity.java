package heh.group.maxel.chingchanchong.adapter.out;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "mangas")
public class MangaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manga")
    private int idManga;

    @Column(name="nom")
    private String nom;

    @Column(name="nb_tome")
    private int nb_tome;

    @Column(name="auteur")
    private String auteur;

    @Column(name = "date_sortie")
    private LocalDate dateSortie;

    @Column(name="synopsis")
    private String synopsis;

    @Column(name="price")
    private float price;

    @Column(name="shop")
    private Boolean shop;

}
