package by.bsu.dektiarev.dao.service;

import by.bsu.dektiarev.dao.enums.ViewsEntity;
import by.bsu.dektiarev.dao.repository.ViewsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by USER on 05.04.2016.
 */
@Service
public class ViewsEntityServiceImpl implements ViewsEntityService {

    @Autowired
    private ViewsEntityRepository viewsEntityRepository;

    @Override
    public ViewsEntity addViews(ViewsEntity viewsEntity) {
        ViewsEntity savedEntity = viewsEntityRepository.saveAndFlush(viewsEntity);
        return savedEntity;
    }
}
