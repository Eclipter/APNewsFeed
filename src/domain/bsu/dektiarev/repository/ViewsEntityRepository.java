package domain.bsu.dektiarev.repository;

import domain.bsu.dektiarev.entity.ViewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by USER on 01.04.2016.
 */
public interface ViewsEntityRepository extends JpaRepository<ViewsEntity, Integer> {

    @Query("UPDATE domain.bsu.dektiarev.entity.ViewsEntity v SET v.viewsCount = v.viewsCount + 1 WHERE v.newsEntityId = :id")
    void addOneView(Integer id);
}
