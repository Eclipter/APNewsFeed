package domain.bsu.dektiarev.service.impl;

import domain.bsu.dektiarev.entity.LikesEntity;
import domain.bsu.dektiarev.repository.LikesEntityRepository;
import domain.bsu.dektiarev.service.LikesEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by USER on 05.04.2016.
 */
@Service
public class LikesEntityServiceImpl implements LikesEntityService {

    @Autowired
    private LikesEntityRepository likesEntityRepository;

    @Override
    public LikesEntity addOneLike(Integer id) {
        if(!likesEntityRepository.exists(id)) {
            LikesEntity likesEntity = new LikesEntity();
            likesEntity.setNewsEntityId(id);
            likesEntity.setLikesCount(1);
            return likesEntityRepository.saveAndFlush(likesEntity);
        }
        likesEntityRepository.addOneLike(id);
        return likesEntityRepository.findOne(id);
    }

    @Override
    public LikesEntity deleteOneLike(Integer id) {
        if(likesEntityRepository.exists(id)) {
            likesEntityRepository.deleteOneLike(id);
        }
        return likesEntityRepository.findOne(id);
    }


}
