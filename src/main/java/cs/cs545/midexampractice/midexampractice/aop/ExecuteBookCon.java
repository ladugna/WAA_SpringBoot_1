package cs.cs545.midexampractice.midexampractice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecuteBookCon {
    @Before("execution(* cs.cs545.midexampractice.midexampractice.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint){
        // implementation to log …
        System.out.println(joinPoint.getSignature().getName()+"  logging for book controller");
    }
}
