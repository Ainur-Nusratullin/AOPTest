package aop;

import aop.config.MyConfig;
import aop.model.Book;
import aop.service.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
//        uniLibrary.getBook();
        uniLibrary.addBook("Ainur", book);
        uniLibrary.addMagazine();

//        uniLibrary.returnBook();
//        uniLibrary.returnMagazine();
//        uniLibrary.addBook();

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
