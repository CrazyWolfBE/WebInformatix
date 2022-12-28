package heh.group.maxel.chingchanchong;


import heh.group.maxel.chingchanchong.adapter.out.MangaMapper;
import heh.group.maxel.chingchanchong.adapter.out.MangaPersistenceAdaptater;
import heh.group.maxel.chingchanchong.adapter.out.MangaRepository;
import heh.group.maxel.chingchanchong.model.Manga;
import heh.group.maxel.chingchanchong.port.in.MangaListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {

    @Autowired
    private MangaRepository mangaRepository;

    private MangaMapper mangaMapper = new MangaMapper();

    @Bean
    MangaListUseCase getMangaListUseCase(){
        return new MangaPersistenceAdaptater(mangaRepository, mangaMapper);
    }


}
