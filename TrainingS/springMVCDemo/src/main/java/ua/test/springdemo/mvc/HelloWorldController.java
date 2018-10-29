package ua.test.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")//parent mapping
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showFrom(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processFrom(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersion2")
    public String letsShoutDude(HttpServletRequest request, Model model){
       String name=request.getParameter("studentName");
       name=name.toUpperCase();
       String result="Yo!"+name;
       model.addAttribute("message", result);
       return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model){
        name=name.toUpperCase();
        String result="Yo! From v3 "+name;
        model.addAttribute("message", result);
        return "helloworld";
    }

}
