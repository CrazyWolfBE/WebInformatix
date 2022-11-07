package heh.group.maxel.chingchanchong.adapter.out;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "manga")
public class MangaJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_manga")
    private int idManga;

    @Column(name="nom")
    private String nom;

    @Column(name="auteur")
    private String auteur;

    @Column(name = "date_sortie")
    private Date dateSortie;

    @Column(name="collection")
    private String collection;
}
