package ua.example.controller;

import org.springframework.web.bind.annotation.*;
import ua.example.exeptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    private int counter =0;
    public List<Map<String, String>> messages=new ArrayList<Map<String, String>>(){{
        add(new HashMap<String,String>(){{put("id", String.valueOf(++counter)); put("text", "First message");}});
        add(new HashMap<String,String>(){{put("id", String.valueOf(++counter)); put("text", "Second message");}});
        add(new HashMap<String,String>(){{put("id", String.valueOf(++counter)); put("text", "Third message");}});
    }};

    @GetMapping
    public List<Map<String, String>> list(){
        return messages;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id){
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message){
        message.put("id", String.valueOf(++counter));
        messages.add(message);
        return message;
    }

    @PutMapping("{id}") // обновление текущей записи
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message){
        Map<String, String> messageFromDb = getMessage(id);
        messageFromDb.put("id", id);
        messageFromDb.putAll(message);
        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> message=getMessage(id);
        messages.remove(message);
    }




}
