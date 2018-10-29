package ua.test.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//bean ID is thatSillyCoach
//@Component("thatSillyCoach")
//bean ID is tennisCoach
@Component
//@Scope("prototype") //но объекты FortuneService одинаковые
// если и над классами реализующими этот интерфейс не указать такой же прототив
public class TennisCoach implements Coach {
    // @Autowired
    // @Value("${foo.email}")//или так, или через сеттер, @Autowired указывать не обязательно
    private String email;
    //через Reflection API
//    @Autowired
    // @Qualifier("randomFortuneService")//указывает конкретную реализацию интерфейса, если их несколкьо
    private FortuneService fortuneService;

    /*   @Autowired
       public TennisCoach(FortuneService fortuneService){
           this.fortuneService=fortuneService;
       }*/
    //если не указывать всё равно работает
    public TennisCoach() {
        System.out.println("TennisCoach: default constructor");
    }

    /* @Autowired
     public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {

         System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");

         fortuneService = theFortuneService;
     }*/
    @Autowired
    public void setFortuneService(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("TennisCoach: setFortuneService");
    }

    @Autowired//@Autowired указывать надо тут
    public void setEmail(@Value("${foo.email}") String email) {
        System.out.println("TennisCoach: setEmail");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    //необязательно так называть метод, достаточно указать только эту аннотацию
    //если два методаб то вызываются оба
    //если конструктор и один метод, то вызывается только метод
 /*   @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("TennisCoach: setFortuneService");
    }/*
    @Autowired
    public void addFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("TennisCoach: addFortuneService");
    }*/

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("TennisCoach: postConstract init");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("TennisCoach: destroy");
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    public String getDailyFortune() {
        return fortuneService.toString();
    }
}
