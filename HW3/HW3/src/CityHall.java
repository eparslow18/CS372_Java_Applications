import java.util.Scanner;
import java.util.ArrayList;
/**
*This class models a City Hall as a type of building
*/
public class CityHall extends Building {

ArrayList<String> CurrentOccupants = new ArrayList<String>(); //just like c++ vector 

	public CityHall(){}
	
	public CityHall(String name){ //call superclass and pass name through 
		super(name);
	}

}