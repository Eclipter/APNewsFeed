package domain.bsu.dektiarev.controller;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

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

    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    private ModelAndView onError(String message) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);
        return modelAndView;
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public ModelAndView addNews(HttpServletRequest req) {
        NewsEntity newsEntity = new NewsEntity();

        int newsId = (int) newsEntityService.countNews() + 1;
        String imagePath = "images/" + newsId + ".jpg";

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        newsEntity.setId(newsId);
        newsEntity.setTitle(title);
        newsEntity.setDescription(description);
        newsEntity.setImagePath(imagePath);
        newsEntityService.addNews(newsEntity);

        Map<String, List<BlobKey>> blobInfos = blobstoreService.getUploads(req);
        BlobKey key = blobInfos.get("image").get(blobInfos.size() - 1);

        try {
            BlobstoreInputStream in = new BlobstoreInputStream(key);
            storageService.uploadImage(imagePath, in);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return index();
    }

    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public void like(@RequestParam(value = "newsId") Integer newsId) {
        likesEntityService.addOneLike(newsId);
    }

    @RequestMapping(value = "/dislike", method = RequestMethod.POST)
    public void dislike(@RequestParam(value = "newsId") Integer newsId) {
        likesEntityService.deleteOneLike(newsId);
    }

    @RequestMapping(value = "/addView", method = RequestMethod.POST)
    public void addView(@RequestParam(value = "newsId") Integer newsId) {
        viewsEntityService.addOneView(newsId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<NewsEntity> newsEntities = newsEntityService.getAllOrderByDesc();
        List<NewsViewEntity> newsViewEntities;
        try {
            newsViewEntities = storageService.convertNewsEntities(newsEntities);
        } catch (IOException e) {
            e.printStackTrace();
            return onError(e.getMessage());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return onError(e.getMessage());
        }

        modelAndView.addObject("newsList", newsViewEntities);
        return modelAndView;
    }
}
