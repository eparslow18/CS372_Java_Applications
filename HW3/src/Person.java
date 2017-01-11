import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


/**
*This class models a person in the city, it is the base class for different types of people
*/
public class Person {
String city;
int age;
String name;
int phoneNum;
int gradeLevel;

	public Person(){}

	public String getCity(){
		return this.city;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return this.age;
	}
	
	

	public void setAge(int age){
		this.age = age;
	}

	public boolean inSchool(){
	return false;
	}
	public boolean teachingSchool(){
		return false;
	}
	
	public boolean inCityHall(){
		return false;
	}
	

	public Person(String name){
		setName(name);
	}
	
	public int getGradeLevel(){
		return this.gradeLevel;
	}
	

}

