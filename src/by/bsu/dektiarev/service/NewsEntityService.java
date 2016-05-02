package by.bsu.dektiarev.service;

import by.bsu.dektiarev.entity.NewsEntity;

import java.util.List;

/**
 * Created by USER on 01.04.2016.
 */
public interface NewsEntityService {

    NewsEntity addNews(NewsEntity newsEntity);
    List<NewsEntity> getAll();
}
