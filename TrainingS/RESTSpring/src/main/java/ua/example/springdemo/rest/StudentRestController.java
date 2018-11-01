package ua.example.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.example.springdemo.entity.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;
    //@PostConstract to load student data.. only once

    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("Ivan", "Sidorov"));
        students.add(new Student("Sveta", "Petrova"));
        students.add(new Student("Vadim", "Igorev"));
    }

    //add code for the "/students" endpoint
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        System.out.println(students.get(studentId));
        return students.get(studentId);
    }
}
