package ua.test.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	public TrackCoach(){}

	public TrackCoach(FortuneService fortuneService){
		this.fortuneService=fortuneService;
	}

	public String getDailyWorkout() {
			return "Run a hard 5k";
	}

	public String getDailyFortune() {
		return "Just Do It: "+fortuneService.getFortune();
	}

	//add init method
	public void doMyStartupStuff(){
		System.out.println("TrackCoach: init");
	}
	public void doMyCleanupStuffYoYo(){
		System.out.println("TrackCoach: destroy");
	}


}
