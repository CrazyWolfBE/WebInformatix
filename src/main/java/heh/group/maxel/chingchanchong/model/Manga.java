package heh.group.maxel.chingchanchong.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class Manga {

    @Getter
    private final int id;

    @Getter
    private final String nom;

    @Getter
    private final String auteur;

    @Getter
    private final Date dateSortie;

    @Getter
    private final String collection;

}
