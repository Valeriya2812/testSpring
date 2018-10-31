package com.example.sweater.controller;


import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessagesRepo messagesRepo;

    @GetMapping("/")
   // public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }
    @GetMapping("/main")
    public String main(Map<String, Object>model){
        Iterable<Message> messages=messagesRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object>model){
        Message message=new Message(text, tag);
        messagesRepo.save(message);
        Iterable<Message> messages=messagesRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String tag, Map<String, Object>model){
        List<Message> messages=messagesRepo.findByTag(tag);
        model.put("messages", messages);

        return "main";
    }


}