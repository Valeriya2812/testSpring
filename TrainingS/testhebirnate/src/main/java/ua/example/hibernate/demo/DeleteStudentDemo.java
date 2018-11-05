package ua.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.example.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try{

            session.beginTransaction();
          //  Student student=session.get(Student.class, 1);
         //   System.out.println("Get:  "+student);

            System.out.println("Deleting... ");
          //  session.delete(student);


            System.out.println("Deleting many...");
            session.createQuery("delete from Student s where s.firstName='Katya'").executeUpdate();
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
