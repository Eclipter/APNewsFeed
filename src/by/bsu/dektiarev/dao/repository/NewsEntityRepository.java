package by.bsu.dektiarev.dao.repository;

import by.bsu.dektiarev.dao.enums.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by USER on 01.04.2016.
 */
@Repository
public interface NewsEntityRepository extends JpaRepository<NewsEntity, Integer> {
}
