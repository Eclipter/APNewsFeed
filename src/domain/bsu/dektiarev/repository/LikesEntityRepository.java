package domain.bsu.dektiarev.repository;

import domain.bsu.dektiarev.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by USER on 01.04.2016.
 */
public interface LikesEntityRepository extends JpaRepository<LikesEntity, Integer> {

    @Query("UPDATE domain.bsu.dektiarev.entity.LikesEntity l SET l.likesCount = l.likesCount + 1 WHERE l.newsEntityId = :id")
    void addOneLike(Integer id);

    @Query("UPDATE domain.bsu.dektiarev.entity.LikesEntity l SET l.likesCount = l.likesCount - 1 WHERE l.newsEntityId = :id")
    void deleteOneLike(Integer id);
}
