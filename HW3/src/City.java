import java.util.Scanner;
import java.util.ArrayList;

/**
*This class models a city, it is the base class for different types of people and buildings
*It contains ArrayLists to hold the different types of people and buildings
*/
public class City {
	
	//city has buildings and people 
	public ArrayList<Building> buildings = new ArrayList<Building>();
	public ArrayList<Person> persons = new ArrayList<Person>();

	/**
	*This function loops through the Arraylist of all persons and prints out the persons name and age 
	*/
	public void allPersons(){ //the names of all people out putted in a loop 
		for (int i = 0; i < persons.size(); i++){
			System.out.printf("Person: %s \t\t\tAge: %s\n", persons.get(i).getName(), persons.get(i).getAge());
		}
	}
	
	
	/**
	*This function loops through the Arraylist of all buildings and prints out the building name and address 
	*/
	public void allBuildings(){ //output building names in a loop
		for (int i = 0; i < buildings.size(); i++){
			System.out.printf("Building: %s \t\tAddress: %s \n", buildings.get(i).getName(), buildings.get(i).getAddress());
		}
	}
	/**
	*This function checks if the kids are in school. If they are, the system prints out so, if not it prints out as well
	*/
	public void kidsInSchool(){
		for (int i = 0; i < persons.size(); i++)
		{
			if (persons.get(i) instanceof Kid){
				Kid k = ((Kid)persons.get(i));
			if(persons.get(i).inSchool() == false && persons.get(i).getAge() <=17){
			System.out.printf("%s is not in school.\n", persons.get(i).getName());
			}
			else if (persons.get(i).inSchool() == true && persons.get(i).getAge() <=17)
			{
			System.out.printf("%s is in school.\n", persons.get(i).getName());
			}
			else 
				return;
			}
		}
	}
	
	/**
	*This function checks if the teachers are teaching in school. If they are, the system prints out so and pays the teacher
	*/
	public void teachersInSchool(){
		for (int i = 0; i < persons.size(); i++)
		{
			
			/* if(persons.get(i).teachingSchool() == false && persons.get(i).getGradeLevel() > 0 ){
			System.out.printf("%s is not teaching school.\n", persons.get(i).getName());
			} */
			if (persons.get(i).teachingSchool() == true && persons.get(i).getGradeLevel() > 0){
			System.out.printf("%s is teaching school and got paid.\n", persons.get(i).getName());
			}
			/* else {
				System.out.printf("failed teachers in school func\n");
				return;
			} */
			
		}
	}
	
	/**
	*This function checks if the officers are in cityhall. If they are, the system prints out so and pays the officer
	*/
	public void officersInCityHall(){
		for (int i = 0; i < persons.size(); i++)
		{
			if (persons.get(i).inCityHall() == true ){
			System.out.printf("%s is in City Hall and got paid.\n", persons.get(i).getName());
			}
		}
	}
	
	public void payEmployees(){
		
	}
	
	/**
	 * Set an array of the people created in main
	 * @param persons takes array of persons
	 */
	
	public void setArrayOfPeople(Person[] persons){
		for (int i = 0; i <persons.length; i++){
			this.persons.add(persons[i]);
		}		
	}
	
	/**
	 * Getter for returning the persons array of type Persons[]
	 * @return persons array of persons
	 */
	public ArrayList<Person> getArrayofPeople(){
		return persons;
	}
}