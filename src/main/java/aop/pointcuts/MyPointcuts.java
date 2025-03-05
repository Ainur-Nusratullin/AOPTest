package aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* ads(..))")
    public void allAddMethods(){
    }
}
