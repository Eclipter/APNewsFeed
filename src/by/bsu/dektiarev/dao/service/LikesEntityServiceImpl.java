package by.bsu.dektiarev.dao.service;

import by.bsu.dektiarev.dao.enums.LikesEntity;
import by.bsu.dektiarev.dao.repository.LikesEntityRepository;
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
