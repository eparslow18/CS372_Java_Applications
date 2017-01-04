import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
System.out.printf("Enter the radius of a circle and I will tell you it's area.\n");
		
		Scanner reader = new Scanner(System.in);
		double n = reader.nextDouble(); 
		final double pi = 3.14;
		
		double area = pi * (n * n);
		

		System.out.printf("%f is the area of a circle with the radius of %f",area, n);
	}

}
