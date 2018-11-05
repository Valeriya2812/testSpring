package ua.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.example.hibernate.demo.entity.Student;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try{
            session.beginTransaction();
           List<Student> studentList=session.createQuery("from ua.example.hibernate.demo.entity.Student").list();
            displayStudents(studentList);

            studentList=session.createQuery("from ua.example.hibernate.demo.entity.Student s where s.lastName='Ivanova' OR " +
                    "s.firstName='Ivan'")
                   .list();
            System.out.println("Students = Ivanova");
            displayStudents(studentList);
            studentList=session.createQuery("from ua.example.hibernate.demo.entity.Student s where s.email LIKE '%gmail.com'")
                    .list();
            System.out.println("email= mail");
            displayStudents(studentList);
            session.getTransaction().commit();
            System.out.println("end");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for(Student s : studentList){
            System.out.println(s);
        }
    }
}
