package eurekaproduct.config;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class LoggingAOP {

    @Around("@annotation(eurekaproduct.annotation.Logging)")
    public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        JoinPoint.StaticPart staticPart = proceedingJoinPoint.getStaticPart();
        String args = Arrays.stream(proceedingJoinPoint.getArgs())
            .map(String::valueOf).collect(Collectors.joining(", "));
        log.info("{} with args [{}] --- START", staticPart, args);
        proceedingJoinPoint.proceed();
        log.info("{} with args [{}] --- END", staticPart, args);
    }
}
