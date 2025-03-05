package aop.aspects;

import aop.model.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution(* aop.service.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){
//    }
//
//    @Pointcut("execution(public void aop.service.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){
//    }
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary(){
//
//    }
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log ###100");
//    }


//    @Pointcut("execution(* aop.service.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("execution(* aop.service.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodUniLibrary(){
//    }
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log ###1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log ###2");
//    }
//
//    @Before("allGetAndReturnMethodUniLibrary()")
//    public void beforeGetAbdReturnLoggingAdvice() {
//        System.out.println("allGetAndReturnMethodUniLibrary: writing Log ###3");
//    }


    @Before("aop.pointcuts.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature = " + methodSignature);
        System.out.println("MethodSignature.getMethod = " + methodSignature.getMethod());
        System.out.println("MethodSignature.returnType = " + methodSignature.getReturnType());
        System.out.println("MethodSignature.getName = " + methodSignature.getName());


        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments){
                if(obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() + ", год издания - " +
                            myBook.getYearOfPublication());
                } else if (obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет: " + obj);
                }
            }
        }


        System.out.println("beforeGetBookAdvice: логирование попытки получить книгу/журнал!!!");
        System.out.println("----------------------------------------------------------------");
    }


}
