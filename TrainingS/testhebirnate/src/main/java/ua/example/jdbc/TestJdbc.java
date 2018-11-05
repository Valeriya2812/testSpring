package ua.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user="lera";
        String password="lera";

        try{
            System.out.println("Connecting "+jdbcUrl);
            Connection mycon= DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connecting ");
        }catch (Exception exc){

        }
    }
}
