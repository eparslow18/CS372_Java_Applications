package pR1_6_Date_Class;
import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) {
		//set month
		System.out.printf("Enter a month.");
		Scanner reader = new Scanner(System.in);
		int month = reader.nextInt(); 	
		Date date = new Date();
		date.setMonth(month);
		
		
		//set day
		System.out.printf("\nEnter a day.");
		int day = reader.nextInt();
		date.setDay(day);
		
		//set year
		System.out.printf("\nEnter a year.");
		int year = reader.nextInt();
		date.setYear(year);
		
		//display date 
		date.displayDate();
	}

}
