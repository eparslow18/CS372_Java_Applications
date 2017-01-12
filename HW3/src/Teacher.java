import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
*This class models a teacher in k-12 and their certification
*/
public class Teacher extends Person implements Employee{
	
	int gradeLevel;
	String certification;
	Random rand = new Random();
	int age1 = rand.nextInt(40);
	int pay;
	int inSchool = rand.nextInt(2);
	
	boolean is;

	/**
	 * Access certification type string of teacher class
	 * @return the teachers certification
	 */
	public String getCert(){
		return this.certification;
	}
	
	/**
	 * Set certification of Teacher class object
	 * @param certification
	 */
	public void setCert(String certification){
		this.certification = certification;
	}	

	/**
	 * Get gradeLevel int of Teacher Class Object
	 */
	public int getGradeLevel(){
		return this.gradeLevel;
	}

	/**
	 * Set gradeLevel string of Teacher class object
	 * @param gradeLevel
	 */
	public void setGradeLevel(int gradeLevel){
		this.gradeLevel = gradeLevel;
	}
	
	/**
	*Return if the teacher is at school
	*@return boolean for teacher in school 
	*/
		public boolean teachingSchool(){
		if (this.inSchool == 0)
		{
			return false;
		}
		else
		{
			setGradeLevel(rand.nextInt(12));
			givePay();
			return true;
		}
	}
	
	/**
	*Set teachers age above 17 years old 
	*/
		public void setAge(){
		this.age = age1 +17;
		}
		
		public Teacher(String name){ //call superclass and pass name through 
		super(name);
		setAge();
		teachingSchool();
		}
		
	/**
	*Pay teacher $2200 for two week work period 
	*function defined from abstact function in Employee interface
	*/	
	public int givePay(){ //two week pay period
		pay = 2200; 
		return pay;
	}
	
	/**
	 * access employeeID from interface employee implemented in class Teacher
	 */
	public void getEmployeeID(){
	}
}