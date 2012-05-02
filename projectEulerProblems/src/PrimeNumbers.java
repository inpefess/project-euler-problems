import java.io.BufferedWriter;
import java.io.FileWriter;

public class PrimeNumbers {
	public static final String fileName = "PrimeNumbers.txt";
	public static final long maxNumber = 1000000; 
	
	public static Boolean isPrime (long n) {
		for (long i = 2; i < n / 2; i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void generatePrimes() {
		try{
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(String.valueOf(2));
			for (long i = 3; i < maxNumber; i += 8) {
				if (isPrime (i)) out.write(String.valueOf(i));
				if (isPrime (i + 2)) out.write(String.valueOf(i + 2));
				if (isPrime (i + 4)) out.write(String.valueOf(i + 4));
			}
			out.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
