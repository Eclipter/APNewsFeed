package domain.bsu.dektiarev.service.impl;

import domain.bsu.dektiarev.entity.NewsEntity;
import domain.bsu.dektiarev.repository.NewsEntityRepository;
import domain.bsu.dektiarev.service.NewsEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 01.04.2016.
 */
@Service
public class NewsEntityServiceImpl implements NewsEntityService {

    @Autowired
    private NewsEntityRepository newsEntityRepository;

    @Override
    public NewsEntity addNews(NewsEntity newsEntity) {
        NewsEntity savedNewsEntity = newsEntityRepository.saveAndFlush(newsEntity);
        return savedNewsEntity;
    }

    @Override
    public List<NewsEntity> getAllOrderByDesc() {
        return newsEntityRepository.findAllByOrderByIdDesc();
    }

    @Override
    public long countNews() {
        return newsEntityRepository.count();
    }
}
