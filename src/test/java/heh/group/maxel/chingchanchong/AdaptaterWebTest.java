package heh.group.maxel.chingchanchong;


import heh.group.maxel.chingchanchong.adapter.in.MangaController;
import heh.group.maxel.chingchanchong.model.Manga;
import heh.group.maxel.chingchanchong.port.in.MangaListUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(MangaController.class)
public class AdaptaterWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MangaListUseCase mangaListUseCase;

    private List<Manga> Manga = new ArrayList<>();

    @Test
    public void testMangaController() throws Exception{
        Manga.add(new Manga(1, "Jujutsu Kaisen", 1,"Lui", LocalDate.of(2010,03,24), "Synopsis", 2.50F, false));
        Manga.add(new Manga(2, "DemonSlayer", 5,"Lui", LocalDate.of(2010,03,24), "Synopsis", 3.50F, true));

        Mockito.when(mangaListUseCase.getMangaList()).thenReturn(Manga);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("mangaList"))
                .andExpect(model().attributeExists("mangas"))
                .andExpect(model().attribute("mangas",Matchers.hasSize(2)));
    }



}
