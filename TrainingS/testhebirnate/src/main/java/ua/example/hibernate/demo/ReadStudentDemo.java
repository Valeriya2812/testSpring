package ua.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.example.hibernate.demo.entity.Student;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try{
            Student student=new Student("Katya", "Shvets", "katyashv@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("end of save transaction");

            System.out.println("Saved student. Generated id: "+student.getId());
            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with id: "+ student.getId());
            Student student1= session.get(Student.class, student.getLastName());
            session.getTransaction().commit();
            System.out.println("end of get transaction");
            System.out.println("Student is:  "+student1.getFirstName()+"  "+ student1.getLastName()+"  "+ student1.getId());
        }
        finally {
            factory.close();
        }
    }
}
