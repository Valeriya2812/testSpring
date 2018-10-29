package ua.test.springdemo;

public interface Coach {
    public String getDailyWorkout();
    public String getDailyFortune();
    default public String getEmail(){
        return null;
    }
}
