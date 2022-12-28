package heh.group.maxel.chingchanchong.adapter.out;

import heh.group.maxel.chingchanchong.model.Manga;
import heh.group.maxel.chingchanchong.port.in.*;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
public class MangaPersistenceAdaptater implements MangaListUseCase, AddMangaUseCase, DeleteMangaUseCase, ModifyMangaUser, AddShop {

    private final MangaRepository mangaRepository;

    private final MangaMapper mangaMapper;

    @Override
    public List<Manga> getMangaList() {
        List<MangaJpaEntity> mangaEntity = mangaRepository.findAll();
        return mangaMapper.mapToDomainEntity(mangaEntity);
    }

    //@Transactional
    @Override
    public void addManga(Manga manga) {
        mangaRepository.save(mangaMapper.ObjectToEntity(manga));
    }

    public void deleteById(int id)
    {
        mangaRepository.deleteById(id);
    }


    @Override
    public Manga getMangaByID(int id) {
        return mangaMapper.IdToManga(mangaRepository.findById(id));
    }

    @Override
    public void addShopDB(int id) {
        mangaRepository.save(mangaMapper.ChangeShop(mangaMapper.IdToManga(mangaRepository.findById(id))));
    }

    @Override
    public void updateManga(Manga manga) {
        mangaRepository.save(mangaMapper.ObjectToEntityID(manga));
    }
}
