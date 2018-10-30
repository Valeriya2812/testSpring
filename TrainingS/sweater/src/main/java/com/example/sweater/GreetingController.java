package com.example.sweater;


import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessagesRepo messagesRepo;

    @GetMapping("/greeting1")
   // public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {

        model.put("name", name);
        return "greeting";
    }
    @GetMapping("/greeting")
    public String main(Map<String, Object>model){
        Iterable<Message> messages=messagesRepo.findAll();
        model.put("messages", messages);
        System.out.println("111");
        return "main";
    }

    @PostMapping("/add")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object>model){
        Message message=new Message(text, tag);
        messagesRepo.save(message);
        Iterable<Message> messages=messagesRepo.findAll();
        model.put("messages", messages);
        System.out.println("222");
        return "main";
    }

}