package heh.group.maxel.chingchanchong.adapter.out;


import heh.group.maxel.chingchanchong.model.Manga;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MangaMapper {

    List<Manga> mapToDomainEntity(List<MangaJpaEntity> mangas){
        List<Manga> mangaList = new ArrayList<>();

        for(MangaJpaEntity mangaJpaEntity: mangas){
            mangaList.add(new Manga(mangaJpaEntity.getIdManga(), mangaJpaEntity.getNom(),mangaJpaEntity.getNb_tome(),mangaJpaEntity.getAuteur(),mangaJpaEntity.getDateSortie(),mangaJpaEntity.getSynopsis(), mangaJpaEntity.getPrice(), mangaJpaEntity.getShop()));
        }
        return mangaList;
    }

    public MangaJpaEntity ObjectToEntity(Manga manga){
        MangaJpaEntity JPAEntity = new MangaJpaEntity();
        JPAEntity.setNom(manga.getNom());
        JPAEntity.setNb_tome(manga.getNb_tome());
        JPAEntity.setAuteur(manga.getAuteur());
        JPAEntity.setDateSortie(manga.getDateSortie());
        JPAEntity.setSynopsis(manga.getSynopsis());
        JPAEntity.setPrice(manga.getPrice());
        JPAEntity.setShop(manga.isShop());
        return JPAEntity;
    }

    public Manga IdToManga(Optional<MangaJpaEntity> mangaJpaEntity){
        if(mangaJpaEntity.isPresent()){
            MangaJpaEntity mangaJpa = mangaJpaEntity.get();
            return new Manga(mangaJpa.getIdManga(), mangaJpa.getNom(),mangaJpa.getNb_tome(),mangaJpa.getAuteur(),mangaJpa.getDateSortie(),mangaJpa.getSynopsis(), mangaJpa.getPrice(), mangaJpa.getShop());
        }
        else{
            return null;
        }

    }

    public MangaJpaEntity ObjectToEntityID(Manga manga){
        MangaJpaEntity JPAEntity = new MangaJpaEntity();
        JPAEntity.setIdManga(manga.getId());
        JPAEntity.setNom(manga.getNom());
        JPAEntity.setNb_tome(manga.getNb_tome());
        JPAEntity.setAuteur(manga.getAuteur());
        JPAEntity.setDateSortie(manga.getDateSortie());
        JPAEntity.setSynopsis(manga.getSynopsis());
        JPAEntity.setPrice(manga.getPrice());
        JPAEntity.setShop(manga.isShop());
        return JPAEntity;
    }

    public MangaJpaEntity ChangeShop(Manga manga){
        MangaJpaEntity JPAEntity = new MangaJpaEntity();
        JPAEntity.setIdManga(manga.getId());
        JPAEntity.setNom(manga.getNom());
        JPAEntity.setNb_tome(manga.getNb_tome());
        JPAEntity.setAuteur(manga.getAuteur());
        JPAEntity.setDateSortie(manga.getDateSortie());
        JPAEntity.setSynopsis(manga.getSynopsis());
        JPAEntity.setPrice(manga.getPrice());
        JPAEntity.setShop(!manga.isShop());

        return JPAEntity;
    }

}
