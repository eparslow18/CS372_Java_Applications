/** 
*This class contains main and executes all of the homework questions
*@author Elisha Parslow 
*/

import java.util.Scanner;
import java.util.ArrayList;


public class CityTest{
	public static void main(String[] args){

	
		City city = new City();
		
	 Person[] personsArray = { new Kid("Joe"), new Kid("Moe"),new Kid("Loe"),new Kid("Poe"),new Kid("Toe"),
			new Police("Dan"), new Police("Lan"), new Police("Tan"), new Police("Man"), new Police("Stan"), 
			new Teacher("Lee"), new Teacher("Ree"), new Teacher("Bee"), new Teacher("Fee"), new Teacher("Dee") 
		};	 
	Building[] buildingsArray = { new CityHall("City Hall"), new School("K12 Learning"), new Building("Pharmacy"), new Building("Gas Station"),
			new Building("Post Office"), new Building("Store"), new Building("Gas Station")			
		};
		
		city.setArrayOfPeople(personsArray);
		
		//output buildings 
		for (int i = 0; i <buildingsArray.length; i++){
		city.buildings.add(buildingsArray[i]);
		}
		city.allBuildings();
		
		//output peoplew2
		for (int i = 0; i <personsArray.length; i++){
		city.persons.add(personsArray[i]);
		}
		city.allPersons();
		
		//kids in school
		city.kidsInSchool();
		
		//teachers in school 
		city.teachersInSchool();
	
		city.officersInCityHall();
	}
}


//Create a City class that models a city, with the people and buildings that are in the city
//You should be able to output the names of all people in a loop
//You should be able to output the names of all buildings in a loop
//You should know which kids and teachers are in school, and which police officers are in City Hall
//You should be able to pay those persons who are employees
