package heh.group.maxel.chingchanchong.port.out;

import heh.group.maxel.chingchanchong.adapter.out.MangaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<MangaJpaEntity, Long> {

}
