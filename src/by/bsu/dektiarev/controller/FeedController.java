package by.bsu.dektiarev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by USER on 21.03.2016.
 */
@Controller
public class FeedController {

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");

        String message = "Running FeedController.index() method";

        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
