package domain.bsu.dektiarev.service.impl;

import domain.bsu.dektiarev.entity.ViewsEntity;
import domain.bsu.dektiarev.repository.ViewsEntityRepository;
import domain.bsu.dektiarev.service.ViewsEntityService;
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

    @Override
    public ViewsEntity addOneView(Integer id) {
        if(!viewsEntityRepository.exists(id)) {
            ViewsEntity viewsEntity = new ViewsEntity();
            viewsEntity.setNewsEntityId(id);
            viewsEntity.setViewsCount(1);
            return addViews(viewsEntity);
        }
        viewsEntityRepository.addOneView(id);
        return viewsEntityRepository.findOne(id);
    }
}
