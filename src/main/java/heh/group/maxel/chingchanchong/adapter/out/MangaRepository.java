package heh.group.maxel.chingchanchong.adapter.out;

import heh.group.maxel.chingchanchong.adapter.out.MangaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface MangaRepository extends JpaRepository<MangaJpaEntity, Integer> {

}
