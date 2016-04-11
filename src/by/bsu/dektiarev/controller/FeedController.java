package by.bsu.dektiarev.controller;

import by.bsu.dektiarev.dao.enums.NewsEntity;
import by.bsu.dektiarev.dao.service.NewsEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by USER on 21.03.2016.
 */
@Controller
public class FeedController {

    @Autowired
    private NewsEntityService newsEntityService;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<NewsEntity> entityList = newsEntityService.getAll();
        String imagePath = entityList.get(0).getImagePath();

        String message = "Running FeedController.index() method";

        modelAndView.addObject("message", message);
        modelAndView.addObject("imagePath", imagePath);
        return modelAndView;
    }
}
