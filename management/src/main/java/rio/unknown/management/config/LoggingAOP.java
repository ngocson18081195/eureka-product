package rio.unknown.management.config;

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

    /**
     * fixme --- implement log exception.
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    @Around("@annotation(rio.unknown.management.annotation.Logging)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) {
        JoinPoint.StaticPart staticPart = proceedingJoinPoint.getStaticPart();
        String args = Arrays.stream(proceedingJoinPoint.getArgs())
            .map(String::valueOf).collect(Collectors.joining(", "));
        Object result = null;
        try {
            log.info("{} with args [{}] --- START", staticPart, args);
            result = proceedingJoinPoint.proceed();
            log.info("{} with args [{}] --- END", staticPart, args);
        } catch (Throwable throwable) {
            log.error("{} with args [{}] error [{}] --- ERROR", staticPart, args, throwable.getMessage());
            throwable.printStackTrace();
        }
        return result;
    }
}
