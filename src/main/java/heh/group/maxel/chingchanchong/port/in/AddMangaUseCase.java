package heh.group.maxel.chingchanchong.port.in;

import heh.group.maxel.chingchanchong.model.Manga;

import javax.transaction.Transactional;

public interface AddMangaUseCase {
    //@Transactional
    void addManga(Manga manga);
}
