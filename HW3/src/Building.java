import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
*This class models a building in the city, it is the base class for different types of buildings
*/
public class Building {
String name;
String address;
Random rand = new Random();
int count = rand.nextInt(100); 
//ArrayList<String> buildingNames = new ArrayList<String>();
//ArrayList<String> buildingAdd = new ArrayList<String>();

	public Building(){}

	public String getName(){
	return this.name;
	}
	
	/**
	 * Set the string name of the Building object 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}	
	
	/**
	 * Access the string name of the Building object 
	 * @return
	 */
		public String getAddress(){
	return this.address;
	}
		
	/**
	 * Set the string address of the Building object 
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}	
	
	/**
	 * Super Constructor for Building and all inheriting classes 
	 * sets name of object from when object is declared 
	 * @param name
	 */
	public Building(String name){
		setName(name);
		//System.out.printf("You are on building.java\n");
		address = (count + " Main Street");
		setAddress(address);

	}

}