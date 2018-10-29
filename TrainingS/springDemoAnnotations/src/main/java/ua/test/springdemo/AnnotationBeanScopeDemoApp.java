package ua.test.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean result=(theCoach==alphaCoach);
        System.out.println("\nresult is " + result);
        System.out.println("\ntheCoach is "+theCoach);
        System.out.println("\nalphaCoach is "+alphaCoach);

        System.out.println("Fortune of theCoach= "+theCoach.getDailyFortune());
        System.out.println("Fortune of alphaCoach= "+ alphaCoach.getDailyFortune());

        context.close();


    }
}
