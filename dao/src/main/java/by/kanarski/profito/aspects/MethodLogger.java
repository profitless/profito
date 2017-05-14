package by.kanarski.profito.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
@Aspect
@Slf4j
public class MethodLogger {

    @Pointcut("execution(* by.kanarski.profito.*.* (..))")
    public void method() {

    }

    @Around("method()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        Class<?> executor = joinPoint.getTarget().getClass();
//        String executorName = executor.getCanonicalName();
        String signatureShort = joinPoint.getSignature().toShortString();
        String args = Arrays.asList(joinPoint.getArgs()).toString();
        log.info("Method: " + signatureShort + "| Args: " + args + "| Started");
        Object result = joinPoint.proceed();
        log.info("Method: " + signatureShort + "| Args: " + args + "| Succeeded");
        return result;
    }

}
