package cs.cs545.midexampractice.midexampractice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecuteAlert {

    @Pointcut("@annotation(cs.cs545.midexampractice.midexampractice.aop.Alert)")
    public void alerting(){

    }

    @After("alerting()")
    public void sendAlert(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"  making a change");
        // implementation to send alert …
    }

}
