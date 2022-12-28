package heh.group.maxel.chingchanchong.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;


@RequiredArgsConstructor
public class Manga {

    @Getter
    private final int id;

    @Getter
    private final String nom;

    @Getter
    private final int nb_tome;

    @Getter
    private final String auteur;

    @Getter
    private final LocalDate dateSortie;

    public int getAn(){
        return dateSortie.getYear();
    }

    @Getter
    private final String synopsis;

    @Getter
    private final float price;

    @Getter
    private final boolean shop;

    @Override
    public String toString(){

        return nb_tome + nom;
    }

}
