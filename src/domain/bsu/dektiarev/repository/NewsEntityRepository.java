package domain.bsu.dektiarev.repository;

import domain.bsu.dektiarev.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by USER on 01.04.2016.
 */
public interface NewsEntityRepository extends JpaRepository<NewsEntity, Integer> {

    List<NewsEntity> findAllByOrderByIdDesc();
}
