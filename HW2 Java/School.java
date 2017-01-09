import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
*This class models a school as a type of building
*/
public class School extends Building {

ArrayList<String> CurrentOccupants = new ArrayList<String>(); //just like c++ vector 


public School (){}

public School(String name){ //call superclass and pass name through 
	super(name);
}

}