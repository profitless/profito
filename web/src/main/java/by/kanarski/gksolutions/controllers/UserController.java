package by.kanarski.gksolutions.controllers;

import by.kanarski.gksolutions.dto.user.FirstUserDto;
import by.kanarski.gksolutions.mailService.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private MailService mailService;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView toRegistration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void registerUser(@RequestBody FirstUserDto firstUserDto,
                             ModelAndView modelAndView, BindingResult bindingResult) {
        log.info("Sended".concat(firstUserDto.toString()));
        mailService.sendRegistrationConfirmation(firstUserDto.getEmail(), "url.url.url", Locale.getDefault());
    }

}
