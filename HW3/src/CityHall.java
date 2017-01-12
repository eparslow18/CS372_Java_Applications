import java.util.Scanner;
import java.util.ArrayList;
/**
*This class models a City Hall as a type of building
*/
public class CityHall extends Building {

	/**
	 * no argument constructor 
	 */
	public CityHall(){}
	
	/**
	 * Contructer for class object CityHall calling super class constructor Building
	 * @param name
	 */
	public CityHall(String name){ //call superclass and pass name through 
		super(name);
	}

}