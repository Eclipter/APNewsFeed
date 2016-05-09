package domain.bsu.dektiarev.repository;

import domain.bsu.dektiarev.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by USER on 01.04.2016.
 */
public interface LikesEntityRepository extends JpaRepository<LikesEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE domain.bsu.dektiarev.entity.LikesEntity l SET l.likesCount = l.likesCount + 1 WHERE l.newsEntityId = :id")
    void addOneLike(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE domain.bsu.dektiarev.entity.LikesEntity l SET l.likesCount = l.likesCount - 1 WHERE l.newsEntityId = :id")
    void deleteOneLike(@Param("id") Integer id);
}
