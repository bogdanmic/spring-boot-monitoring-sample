package dev.spring.simple.service.aspect;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("@annotation(LogPerformance)")
    public Object doAroundWithAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnVal = proceedingJoinPoint.proceed();
        log.info("PERFORMANCE[ {}ms ]: {}.{}([{}])", (System.currentTimeMillis() - start), // duration
                proceedingJoinPoint.getTarget().getClass(), // class
                proceedingJoinPoint.getSignature().getName(), // method
                getArgumentsWithLimit(proceedingJoinPoint.getArgs())); // arguments
        return returnVal;
    }

    private String getArgumentsWithLimit(Object[] args) {
        int limit = 100; // limit the argument sizes in the log message
        return Arrays.stream(args).map(String::valueOf)
                .map(str -> str.length() > limit ? str.substring(0, limit) + " ..." : str)
                .collect(Collectors.joining(","));
    }
}
