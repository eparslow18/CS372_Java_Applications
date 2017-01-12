import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
*This class models a police officer and their role 
*/
public class Police extends Person implements Employee{
	String role;
	Random rand = new Random();
	int age1 = rand.nextInt(40); 
	int pay;
	int inCityHall = rand.nextInt(2);

	/**
	 * 
	 */
	public String getRole(){
		return this.role;
		}
	/**
	 * 
	 * @param role
	 */
	public void setRole(String role){
		this.role = role;
	}
	
	/**
	 * 
	 */
	public void setCity(String role){
		this.role = role;
		}
	
	/**
	*Return if the officer is in city hall
	*@return boolean is in city hall
	*/
	public boolean inCityHall(){
		if (this.inCityHall == 0)
		{
			return false;
		}
		else
		{
			givePay();
			return true;
		}
	}
		
		
		/**
	*Set officers age above 17 years old 
	*/
	public void setAge(){
		this.age = age1 +17;
		}
		
	public Police(String name){ //call superclass and pass name through 
		super(name);
		setAge();
		setRole("Sherrif");
		}
	
	/**
	*Pay officer $000 for two week work period 
	*function defined from abstact function in Employee interface
	*/	
	public int givePay(){ //two week pay period
		pay = 4000; 
		return pay;
	}
	
	public void getEmployeeID(){
		
	}
	
}