
public class IntegerValueOfACharcter {

	public static void main(String[] args) {
/*		System.out.printf("The integer equivant of %c is %d\n",'A', ((int)'A'));
		System.out.printf("The integer equivant of %c is %d\n",'B', ((int)'B'));
		System.out.printf("The integer equivant of %c is %d\n",'C', ((int)'C'));
		System.out.printf("The integer equivant of %c is %d\n",'a', ((int)'a'));
		System.out.printf("The integer equivant of %c is %d\n",'b', ((int)'b'));
		System.out.printf("The integer equivant of %c is %d\n",'c', ((int)'c'));
		
		System.out.printf("The integer equivant of %c is %d\n",'1', ((int)'1'));
		System.out.printf("The integer equivant of %c is %d\n",'2', ((int)'2'));
		System.out.printf("The integer equivant of %c is %d\n",'$', ((int)'$'));
		System.out.printf("The integer equivant of %c is %d\n",'^', ((int)'^'));
		System.out.printf("The integer equivant of %c is %d\n",'.', ((int)'.'));
		System.out.printf("The integer equivant of %c is %d\n",'/', ((int)'/'));
		System.out.printf("The integer equivant of '%c' is %d\n",' ', ((int)' '));*/

		char[] values ={'A', 'B', 'C', 'a', 'b', 'c', '1', '2', '3','$','^','.', '/', ' '};
		for (int i = 0; i<values.length; i++)
		{
			System.out.printf("The integer equivalent of %c is %d\n",values[i], ((int)values[i]));
		}
	}

}
