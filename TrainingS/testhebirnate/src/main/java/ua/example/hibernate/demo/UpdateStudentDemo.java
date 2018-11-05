package ua.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.example.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try{

            session.beginTransaction();
            Student student=session.get(Student.class, 1);
            System.out.println("Get:  "+student);

            System.out.println("Updating... ");
            student.setFirstName("Stas");
            session.getTransaction().commit();
            System.out.println("end of save transaction");
            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating email..");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();


            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
