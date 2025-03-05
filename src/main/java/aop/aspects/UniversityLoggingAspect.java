package aop.aspects;

import aop.model.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение " +
                "списка студентов перед методом getStudents");
    }

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){

        Student firsStudent =  students.get(0);

        String nameSurname = firsStudent.getNameSurname();
        nameSurname = "Mr." + nameSurname;
        firsStudent.setNameSurname(nameSurname);

        double avgGrade = firsStudent.getAvgGrade();
        avgGrade = avgGrade + 1;
        firsStudent.setAvgGrade(avgGrade);

        int course = firsStudent.getCourse();
        course = course - 1;
        firsStudent.setCourse(course);


        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение " +
                "списка студентов после работы метода getStudents");
    }

}
