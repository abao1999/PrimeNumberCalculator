package FinalPrimeCalculator;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
/** This program puts together a prime number generator and a prime number counter
 *  
 */
public class PrimeHelper4 {
	static JOptionPane frame = new JOptionPane();
	public static boolean isPrime(long num){ //method signature. returns Boolean, true if number isPrime, false if not
	    if(num==2){ //for case num=2, function returns true. detailed explanation underneath
	      return true;
	    }
	    else if (num<2) return false;
	    for(int i=2;i<=(int)Math.sqrt(num)+1;i++){ //loops through 2 to sqrt(num). All you need to check- efficient
	      if(num%i==0){ //if a divisor is found, its not prime. returns false
	        return false;
	      }
	    }
	    return true; //if all cases don't divide num, it is prime.
	}
	//Gets the input and calls it number
	public static long getNumber()	{
		      long number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number N: "));
		      return number;
	}
	//Sees how many primes there are less or equal to number, and calls it N
	public static long getN(long number) {
	        boolean[] isPrime = new boolean[(int)number+1];
	        long N = 0;
	        for (int i = 2; i <= number; i++) {
	            isPrime[i] = true;
	        }
	        // Examines all i<=N to look for non-prime numbers
	        for (int i = 2; Math.pow(i, 2) <= number; i++) { // this stupid thing limits... don't need i^2 but had to do it idiot but why? it's stupid
	            // Finds all multiples of i if i is prime, since multiples of i will not be prime
	            if (isPrime[i]) {
	                for (int j = i; i*j <= number; j++) {
	                    isPrime[i*j] = false;
	                }
	            }
	        }
	        // Counts the number of primes that are less than or equal to N
	        for (int i = 2; i <=number; i++) { 
	            if (isPrime[i]) N++;
	        }
	        return N;
	}
	//Finds all primes less than or equal to number
	public static void displayPrime(long number)	{
		ArrayList<Long> nums = new ArrayList<Long>();
		long start=2; nums.add(start);
	    int status = 1;
	    long num = 3;
	      for ( int count = 2; count <number;  )	{ //runs this program until [count=n] primes are found
	         for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )  { //j is the factor, and the program checks if the num is divisible by it. 
	        	 if ( num%j == 0 )  {
	        		status = 0;
	               break;
	            }
	         }
	         	if (status != 0 ) {
	         		nums.add(num);
	         		count++; //1 more prime number has been found
	            }
	         	  status = 1;
		    	  num++;
	      }
	    JTextArea textArea = new JTextArea(Arrays.toString(nums.toArray()));
	    JScrollPane scrollPane = new JScrollPane(textArea);  
	    textArea.setLineWrap(true);  
	    textArea.setWrapStyleWord(true); 
	    scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
	    JOptionPane.showMessageDialog(frame, scrollPane, "Anthony Bao's Prime Number Calculator", JOptionPane.YES_NO_OPTION);
	}
	public static void theEnd()	{
	    for (int i = 0; i<=100; i++)	{
		  char choice = (JOptionPane.showInputDialog("====================Anthony Bao's Multi-Purpose Prime Number Calculator====================="
					+ "\n                                                                         You name it, I do it"
				+ "\n Please enter the number corresponding to your choice:"
		  		+ "\n A: What are all prime numbers less than or equal to number?"
		  		+ "\n B: What are the first N prime numbers?"
			    + "\n C: How many prime numbers are less than or equal to number?"
		  		+ "\n D: Is this number prime?")).toLowerCase().charAt(0);
		  if (choice=='a') {
			  long number = getNumber();
			  long N = getN(number)+1;
			  displayPrime(N);
		  }
		  else if (choice=='b')	{
			  long number = getNumber()+1;
			  displayPrime(number);
		  }
		  else if (choice=='c')	{
			  long number = getNumber();
			  long num = getN(number);
			  JOptionPane.showMessageDialog(frame, num);
		  }
		  else if (choice=='d')	{
			  long number = getNumber();
			  boolean answer = isPrime(number);
			  if (number>2147483647||number<0) JOptionPane.showMessageDialog(frame, "An error occurred. The input may have been invalid");
			  else if (answer==true) JOptionPane.showMessageDialog(frame, number + " is PRIME");
			  else if (answer==false) JOptionPane.showMessageDialog(frame, number + " is NOT PRIME");
		  }
	    }
	}
	public static void main(String[] args)	{
		theEnd();
	}
}
