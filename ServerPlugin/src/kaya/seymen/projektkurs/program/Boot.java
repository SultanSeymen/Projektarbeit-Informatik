package kaya.seymen.projektkurs.program;

public class Boot {

	public static void main(String[] args)
	{
		Human max = new Human("Max",18,"Programmierer","Badminton");
		
		Human lea = new Human("Lea",17,"Aerztin","Haekeln");
		
		max.printInformation();
		
		lea.printInformation();
		
		lea.getJob();
	}
	
}
