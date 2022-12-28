package heh.group.maxel.chingchanchong;


import heh.group.maxel.chingchanchong.adapter.out.MangaMapper;
import heh.group.maxel.chingchanchong.adapter.out.MangaPersistenceAdaptater;
import heh.group.maxel.chingchanchong.adapter.out.MangaRepository;
import heh.group.maxel.chingchanchong.model.Manga;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterPersistenceTest extends AbstractIntegrationTest{

    @Autowired
    private MangaRepository mangaRepository;
    private MangaMapper mangaMapper;

    private MangaPersistenceAdaptater mangaPersistenceAdaptater;

    @Test
    @Sql({"createMangaTable.sql","dataManga.sql"})
    void getMangasList(){
        mangaMapper = new MangaMapper();
        mangaPersistenceAdaptater = new MangaPersistenceAdaptater(mangaRepository,mangaMapper);

        List<Manga> mangas;

        mangas = mangaPersistenceAdaptater.getMangaList();


        assertEquals("jujutsu",mangas.get(0).getNom());

        assertEquals(2,mangas.get(0).getNb_tome());
        assertEquals(1990,mangas.get(0).getDateSortie().getYear());
        assertEquals("lui",mangas.get(0).getAuteur());
        assertEquals("synopsis trop cool",mangas.get(0).getSynopsis());
    }
}