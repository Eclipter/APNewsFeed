package domain.bsu.dektiarev.service;

import domain.bsu.dektiarev.entity.ViewsEntity;

/**
 * Created by USER on 02.04.2016.
 */
public interface ViewsEntityService {

    ViewsEntity addViews(ViewsEntity viewsEntity);
    ViewsEntity addOneView(Integer id);
}
