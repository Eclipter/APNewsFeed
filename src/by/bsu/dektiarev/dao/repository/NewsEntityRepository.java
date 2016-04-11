package by.bsu.dektiarev.dao.repository;

import by.bsu.dektiarev.dao.enums.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by USER on 01.04.2016.
 */
public interface NewsEntityRepository extends JpaRepository<NewsEntity, Integer> {
}
