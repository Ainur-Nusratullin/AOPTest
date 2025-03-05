package aop.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Ainur Nusratullin", 4, 7.5);
        Student st2 = new Student("Aleksandr Ovechkin", 2, 8.1);
        Student st3 = new Student("Evgeniy Malkin", 1, 7.2);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Information from method getStudents:");
        System.out.println(students);
        return students;
    }
}
