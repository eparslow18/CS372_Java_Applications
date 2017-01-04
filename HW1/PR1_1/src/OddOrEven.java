import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		System.out.printf("Enter a number and I will tell you if it is odd or even.\n");
		
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt(); 
		
		if((n %2) == 0)
		{
			System.out.printf("%d is an even number.", n);
		}
		else
			System.out.printf("%d is an odd number.", n);		
	}
	

}
