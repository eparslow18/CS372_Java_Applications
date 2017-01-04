import java.util.Scanner;

public class BodyMassIndext {

	public static void main(String[] args) {
		System.out.printf("Enter your weight in pounds.\n");
		Scanner reader = new Scanner(System.in);
		double weight = reader.nextDouble(); 
		
		
		System.out.printf("Enter your height in inches.\n");
		double height = reader.nextDouble(); 
		
		double bmi = (weight * 703) / (height * height);
		System.out.printf("Your BMI is %f.\nBMI VALUES\nNormal: \tbetween 12.5 and 24.9\nOverweight: \tbetween 25 and 29.9\nObese: \t\t30 or greater", bmi);
		

	}

}
