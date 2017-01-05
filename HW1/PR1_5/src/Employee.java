
public class Employee {
	String firstName;
	String lastName;
	double monthlySalary;
	
	
	//constructor 
	public Employee(){
		firstName ="";
		lastName ="";
		monthlySalary = 0.0;
	}
	
	//getters and setters for variables 
	public void setFirstName(String fName){
		this.firstName = fName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setLastName(String lName){
		this.lastName = lName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setMonthlySalary(double salary){//only set if value is not negative
		if (salary >= 0){
		this.monthlySalary = salary;
		}
	}
	public double getMonthlySalary(){
		return this.monthlySalary;
	}
	
	
}
