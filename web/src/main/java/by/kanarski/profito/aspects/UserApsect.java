package by.kanarski.profito.aspects;

import by.kanarski.profito.dto.user.FirstUserDto;
import by.kanarski.profito.validation.analyze.ValidationAnalyzer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
@Aspect
@Slf4j
public class UserApsect {

    @Pointcut("execution(public void" +
            " by.kanarski.profito.controllers.UserController.registerUser(" +
            " by.kanarski.profito.dto.user.FirstUserDto, ..))")
    public void method() {

    }

//    @Around("method()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        FirstUserDto firstUserDto = ((FirstUserDto) joinPoint.getArgs()[0]);
        List<FieldError> errorList = new ValidationAnalyzer().checkEq(firstUserDto);
        BindingResult bindingResult = ((BindingResult) joinPoint.getArgs()[1]);
        bindingResult.addError(errorList.get(0));
        firstUserDto.setIsPasswordsEquals(firstUserDto.isPasswordsEquals());
        return joinPoint.proceed();
    }

}
