package by.kanarski.gksolutions.controllers;

import by.kanarski.gksolutions.constants.Pages;
import by.kanarski.gksolutions.constants.Parameter;
import by.kanarski.gksolutions.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
@RequestMapping(Pages.PAGE_START)
@Slf4j
public class IndexController {


    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = {Pages.PAGE_INDEX, Pages.PAGE_START}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView toMainPage(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject(Parameter.USER, new UserDto());
        modelAndView.setViewName(Pages.PAGE_INDEX);
        Logger logger = LoggerFactory.getLogger(getClass());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Throwable exception) {
        log.error(exception.getMessage(), exception);
        return Pages.PAGE_ERROR;
    }

    private String getMessage(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

}
