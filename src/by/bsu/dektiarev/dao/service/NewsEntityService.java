package by.bsu.dektiarev.dao.service;

import by.bsu.dektiarev.dao.enums.NewsEntity;

import java.util.List;

/**
 * Created by USER on 01.04.2016.
 */
public interface NewsEntityService {

    NewsEntity addNews(NewsEntity newsEntity);
    List<NewsEntity> getAll();
}
