package by.bsu.dektiarev.controller;

import by.bsu.dektiarev.entity.NewsEntity;
import by.bsu.dektiarev.service.LikesEntityService;
import by.bsu.dektiarev.service.NewsEntityService;
import by.bsu.dektiarev.service.StorageService;
import by.bsu.dektiarev.service.ViewsEntityService;
import com.google.api.services.storage.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.GeneralSecurityException;
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

    public String getImageFromBucket() {
        try {
            Bucket bucket = storageService.getBucket("newsfeed_data");
            return bucket.getLocation();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return "Error123";
    }

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<NewsEntity> entityList = newsEntityService.getAll();
        String imagePath = entityList.get(0).getImagePath();

        String message = "Running FeedController.index() method";

        String imageFromBucket = getImageFromBucket();

        modelAndView.addObject("bucket", imageFromBucket);
        modelAndView.addObject("message", message);
        modelAndView.addObject("imagePath", imagePath);
        return modelAndView;
    }
}
