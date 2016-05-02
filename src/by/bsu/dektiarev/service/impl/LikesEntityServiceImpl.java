package by.bsu.dektiarev.service.impl;

import by.bsu.dektiarev.entity.LikesEntity;
import by.bsu.dektiarev.repository.LikesEntityRepository;
import by.bsu.dektiarev.service.LikesEntityService;
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
    public LikesEntity addLikes(LikesEntity likesEntity) {
        LikesEntity savedEntity = likesEntityRepository.saveAndFlush(likesEntity);
        return savedEntity;
    }
}
