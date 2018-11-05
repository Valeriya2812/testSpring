package ua.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.example.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try{
            Student student1=new Student("Maria", "Ivanova", "mariaivanov@gmail.com");
            Student student2=new Student("Sveta", "Victorova", "svetav@gmail.com");
            Student student3=new Student("Sidor", "Ivanov", "sidorivanov@gmail.com");

            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
            System.out.println("end");
        }
        finally {
            factory.close();
        }

    }
}
