package pR1_6_Date_Class;

public class Date {
	int month;
	int day; 
	int year;
	
	public Date(){
		month = 01;
		day = 01;
		year = 0000;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	public int getMonth(){
		return this.month;
	}
	public void setDay(int day){
		this.day = day;
	}
	public int getDay(){
		return this.day;
	}
	public void setYear(int year){
		this.year = year;
	}
	public int getYear(){
		return this.year;
	}
	
	public void displayDate()
	{
		System.out.printf("\nThe date is %d/%d/%d", this.month, this.day, this.year);
	}
	
}
