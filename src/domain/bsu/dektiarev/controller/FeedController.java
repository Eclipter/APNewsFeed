package domain.bsu.dektiarev.controller;

import domain.bsu.dektiarev.entity.NewsEntity;
import domain.bsu.dektiarev.entity.NewsViewEntity;
import domain.bsu.dektiarev.service.LikesEntityService;
import domain.bsu.dektiarev.service.NewsEntityService;
import domain.bsu.dektiarev.service.StorageService;
import domain.bsu.dektiarev.service.ViewsEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 21.03.2016.
 */
@Controller
public class FeedController {

    @Autowired
    private NewsEntityService newsEntityService;

    @Autowired
    private LikesEntityService likesEntityService;

    @Autowired
    private ViewsEntityService viewsEntityService;

    @Autowired
    private StorageService storageService;

    public List<NewsViewEntity> getNews() {
        List<NewsEntity> entityList = newsEntityService.getAll();
        List<NewsViewEntity> newsViewEntities = new ArrayList<>();
        for(NewsEntity newsEntity : entityList) {
            try {
                newsViewEntities.add(storageService.convertNewsEntity(newsEntity));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
        return newsViewEntities;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void doPost() {

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<NewsViewEntity> newsViewEntities = getNews();

        modelAndView.addObject("newsList", newsViewEntities);
        return modelAndView;
    }
}
