package ua.test.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class RandomFortuneService implements FortuneService{

    private String [] data={
            "String1",
            "String2",
            "String3"
    };

    private Random myRandom=new Random();

    public String getFortune() {
        int index= myRandom.nextInt(data.length);
        return data[index];
    }
}
