package domain.bsu.dektiarev.service;

import domain.bsu.dektiarev.entity.LikesEntity;

/**
 * Created by USER on 02.04.2016.
 */
public interface LikesEntityService {

    LikesEntity addLikes(LikesEntity likesEntity);
    LikesEntity addOneLike(Integer id);
    LikesEntity deleteOneLike(Integer id);
}
