package ua.example.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Driver {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper=new ObjectMapper();

            File f =new File ("the-file-name.txt");
            if (f.exists())
                System.out.println(f.getAbsolutePath());

         /*   Student student=mapper.readValue(new File("file: data/sample-lite.json"), Student.class);
            System.out.println("First name = "+student.getFirstName());
            System.out.println("Last name = "+student.getLastName());
*/
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
