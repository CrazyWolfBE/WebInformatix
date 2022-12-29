package heh.group.maxel.chingchanchong.adapter.in;


import heh.group.maxel.chingchanchong.model.Manga;
import heh.group.maxel.chingchanchong.port.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class MangaController {
    private final MangaListUseCase mangaListUseCase;

    private final AddMangaUseCase addMangaUseCase;

    private final DeleteMangaUseCase deleteMangaUseCase;
    private final ModifyMangaUser modifyMangaUser;
    private final AddShop addShop;


    private List<Manga> mangas;

    @GetMapping("/")
    public String mangaList(Model model, @AuthenticationPrincipal OidcUser principal){
        mangas = mangaListUseCase.getMangaList();
        model.addAttribute("mangas",mangas);
        if(principal != null){
            model.addAttribute("user", principal.getClaims());
        }
        return "mangaList";
    }

    @GetMapping("/addmanga")
    public String mangaRegister(Model model, @AuthenticationPrincipal OidcUser principal){

        if(TestAdmin(principal)){
            return "redirect:/";
        }
        Manga manga = new Manga(1, "", 0, "", LocalDate.of(1990,1,1), "", 2.50F, false);
        model.addAttribute("manga",manga);
        return "addmanga";
    }

    @PostMapping("/addmanga_succeed")
    public String mangaAdding(@ModelAttribute("manga") Manga manga, @AuthenticationPrincipal OidcUser principal){
        if(TestAdmin(principal)){
            return "redirect:/";
        }
        addMangaUseCase.addManga(manga);
        return "mangaSuccess";
    }

    @GetMapping("/delete")
    public String deleteManga(Integer id, @AuthenticationPrincipal OidcUser principal)
    {
        if(TestAdmin(principal)){
            return "redirect:/";
        }
        deleteMangaUseCase.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/modify")
    public String ModifyManga(Integer id, Model model, @AuthenticationPrincipal OidcUser principal)
    {
        if(TestAdmin(principal)){
            return "redirect:/";
        }
        model.addAttribute("manga",modifyMangaUser.getMangaByID(id));
        return "modifymanga";
    }

    @PostMapping("/modifymanga_succeed")
    public String ModifyMangaIntoDB(@ModelAttribute("manga") Manga manga, @AuthenticationPrincipal OidcUser principal){
        if(TestAdmin(principal)){
            return "redirect:/";
        }
        modifyMangaUser.updateManga(manga);
        return "modifySuccess";
    }

    @GetMapping("/acheter")
    public String addToPanier(Integer id,Boolean shop, Model model, @AuthenticationPrincipal OidcUser principal){
        if (!shop) {
            addShop.addShopDB(id);
        }

        return "redirect:/";
    }


    public boolean TestAdmin(@AuthenticationPrincipal OidcUser principal){
        if(principal == null){
            return true;
        } else if (!Objects.equals(principal.getClaims().get("name"), "maxime.rossbach@std.heh.be") && !Objects.equals( principal.getClaims().get("name"), "axel.hoffmann@std.heh.be")) {
            return true;
        }
        else{
            return false;
        }
    }

    @GetMapping("/shop")
    public String mangaShop(Model model, @AuthenticationPrincipal OidcUser principal){
        mangas = mangaListUseCase.getMangaList();
        model.addAttribute("mangas",mangas);

        return "shop";
    }

    @GetMapping("/enlever")
    public String deleteToPanier(Integer id, Model model, @AuthenticationPrincipal OidcUser principal){

        addShop.addShopDB(id);

        return "redirect:/shop";
    }
    


}
