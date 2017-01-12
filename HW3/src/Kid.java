import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
*This class models a kid and their favorite candy 
*/
public class Kid extends Person{
	String favCandy;
	Random rand = new Random();
	int age1 = rand.nextInt(17); 
	int inSchool = rand.nextInt(2);
	boolean is;
	
	
	/**
	 * Return a string of the kid class favorite candy
	 */
	public String getFavCandy(){
	return this.favCandy;
	}
	
	/**
	 * Set a Kid's favorite candy
	 * @param favCandy
	 */
	public void setFavCandy(String favCandy){
		this.favCandy = favCandy;
	}	
	
	/**
	 * set the age of a Kid class
	 */
		public void setAge(){
		this.age = age1;
	}
	
	/**
	*Return if the kid is at school
	*@return boolean for kid in school 
	*/
	public boolean inSchool(){
		if (this.inSchool == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	*Constructor specific to kid 
	*@param holding the kids name 
	*/
	public Kid(String name){ //call superclass and pass name through 
	super(name);
	setAge();
	inSchool();
	setFavCandy("Snickers");
	}

}