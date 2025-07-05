package com.example.springbootproject.logging;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.exceptions.PersonNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PersonServiceAspect {
    private static final Logger logger = LoggerFactory.getLogger(PersonServiceAspect.class);

    @Around("execution(* com.example.springbootproject.services.PersonServiceImpl.*(..))")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Entering method: {} with args: {}", methodName, args);

        try {
            Object result = joinPoint.proceed();
            if (methodName.startsWith("get") && !methodName.equals("getById")) {
                logger.debug("Exiting method: {}, found {} items", methodName, ((List<?>) result).size());
            } else {
                logger.debug("Exiting method: {}, result: {}", methodName, result);
            }
            return result;
        } catch (Exception e) {
            if (e instanceof PersonNotFoundException) {
                logger.warn("Person with ID: {} does not exist", args[0]);
                logger.debug("Exiting method: {}", methodName);
                return null;
            } else {
                logger.error("Exception in method: {}", methodName, e);
                throw e;
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.springbootproject.services.PersonServiceImpl.create(..))",
            returning = "result")
    public void logAfterCreate(Object result) {
        if (result instanceof PersonDTO dto) {
            logger.debug("Created person with ID: {}", dto.getId());
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.springbootproject.services.PersonServiceImpl.remove(..)) && args(id)",
            argNames = "id")
    public void logAfterRemove(Long id) {
        logger.debug("Deleted person with ID: {}", id);
    }

    @AfterThrowing(pointcut = "execution(* com.example.springbootproject.services.PersonServiceImpl.*(..))",
            throwing = "ex")
    public void logAfterThrowing(Exception ex) {
        logger.error(ex.getMessage());
    }
}
