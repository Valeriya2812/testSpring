package ua.test.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel){
        Student student=new Student();
        theModel.addAttribute("student", student);
        return "student-form";
    }

    @RequestMapping("/processFrom")
    public String processFrorm(@ModelAttribute("student") Student student){

        System.out.println("theStudent: "+student.getFirstName()+" "+ student.getLastName());
        return "student-confirmation";
    }

}
