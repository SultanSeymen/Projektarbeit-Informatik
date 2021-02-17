package kaya.seymen.projektkurs.program;

public class Human {

	private String name,job,hobby;
	private int alter;
	
	public Human(String name, int alter, String job, String hobby)
	{
		this.name = name;
		this.alter = alter;
		this.job = job;
		this.hobby = hobby;
	}
	
	
	public void printInformation()
	{
		System.out.println("Name der Person " + name);
		System.out.println("Alter der Person " + alter);
		System.out.println("Job der Person " + job);
		System.out.println("Hobby der Person " + hobby);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public int getAlter() {
		return alter;
	}


	public void setAlter(int alter) {
		this.alter = alter;
	}
	
	
}
