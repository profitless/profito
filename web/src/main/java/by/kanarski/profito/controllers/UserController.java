package by.kanarski.profito.controllers;

import by.kanarski.profito.constants.Pages;
import by.kanarski.profito.dto.user.FirstUserDto;
import by.kanarski.profito.mailService.MailService;
import by.kanarski.profito.services.interfaces.IFirstUserService;
import by.kanarski.profito.utils.TokenGenerator;
import by.kanarski.profito.wrappers.EmailConfirmationInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private MailService mailService;
    private IFirstUserService firstUserService;
    private TokenGenerator tokenGenerator;

    @Autowired
    public UserController(MailService mailService, IFirstUserService firstUserService, TokenGenerator tokenGenerator) {
        this.mailService = mailService;
        this.firstUserService = firstUserService;
        this.tokenGenerator = tokenGenerator;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView toRegistration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void registerUser(@RequestBody FirstUserDto firstUserDto,
                             ModelAndView modelAndView, BindingResult bindingResult) {
        String activationKey = firstUserService.registerUser(firstUserDto);
        EmailConfirmationInfo emailConfirmationInfo = new EmailConfirmationInfo(firstUserDto.getEmail(),
                activationKey, Locale.getDefault());
        mailService.sendEmailConfirmation(emailConfirmationInfo);
    }

    @RequestMapping(path = "/email/{activationKey}", method = RequestMethod.GET)
    public ModelAndView confirmEmail(ModelAndView modelAndView, @PathVariable String activationKey) {
        firstUserService.activateUser(activationKey);
        modelAndView.setViewName("confirmation");
        return modelAndView;
    }

    @ExceptionHandler
    public String handleException(Throwable exception) {
        log.error(exception.getMessage(), exception);
        return Pages.PAGE_ERROR;
    }

}
