package by.kanarski.profito.controllers;

import by.kanarski.profito.constants.Pages;
import by.kanarski.profito.dto.company.CompanyInfoDto;
import by.kanarski.profito.dto.user.ConfirmationUser;
import by.kanarski.profito.dto.user.FirstUserDto;
import by.kanarski.profito.ebp.events.OnRegistrationCompleteEvent;
import by.kanarski.profito.services.interfaces.IFirstUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private IFirstUserService firstUserService;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserController(IFirstUserService firstUserService, ApplicationEventPublisher eventPublisher) {
        this.firstUserService = firstUserService;
        this.eventPublisher = eventPublisher;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView toRegistration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void registerUser(@RequestBody @Valid FirstUserDto firstUserDto, BindingResult bindingResult,
                             ModelAndView modelAndView,
                             HttpServletRequest request) {
        ConfirmationUser confirmationUser = firstUserService.registerUser(firstUserDto);
        String appUrl = getAppUrl(request);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(confirmationUser, Locale.getDefault(), appUrl));
    }

    @RequestMapping(path = "/email/{activationKey}", method = RequestMethod.GET)
    public ModelAndView confirmEmail(ModelAndView modelAndView, @PathVariable String activationKey) {
        firstUserService.activateUser(activationKey);
        modelAndView.setViewName("confirmation");
        return modelAndView;
    }

    public void editCompanyInfo(@RequestBody CompanyInfoDto companyInfoDto) {

    }

    @ExceptionHandler
    public String handleException(Throwable exception) {
        log.error(exception.getMessage(), exception);
        return Pages.PAGE_ERROR;
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
