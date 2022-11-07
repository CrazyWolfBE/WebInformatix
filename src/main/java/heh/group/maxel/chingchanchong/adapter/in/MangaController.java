package heh.group.maxel.chingchanchong.adapter.in;


import heh.group.maxel.chingchanchong.model.Manga;
import heh.group.maxel.chingchanchong.port.in.MangaListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MangaController {

    private final MangaListUseCase mangaListUseCase;

    private List<Manga> mangas;

    @GetMapping("/")
    public String mangaList(Model model){
        mangas = mangaListUseCase.getMangaList();
        model.addAttribute("mangas",mangas);
        return "mangaList";
    }
}
