package ua.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    public List<Map<String, String>> messages=new ArrayList<Map<String, String>>(){{
        add(new HashMap<String,String>(){{put("id", "1"); put("test", "First message");}});
        add(new HashMap<String,String>(){{put("id", "2"); put("test", "Second message");}});
        add(new HashMap<String,String>(){{put("id", "3"); put("test", "Third message");}});
        }};

    @GetMapping
    public List<Map<String, String>> list(){
        return messages;
    }

}