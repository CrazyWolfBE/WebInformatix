package heh.group.maxel.chingchanchong.port.in;

import heh.group.maxel.chingchanchong.model.Manga;

public interface ModifyMangaUser {

    Manga getMangaByID(int id);

    void updateManga(Manga manga);
}
