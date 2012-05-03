import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

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
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
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
	
	public static void getPrimes(ArrayList<Long> primes, long nextNum) {
		long remainder = nextNum;
		for (int i = 0; i < primes.size() || remainder > 1; i ++) {
			while (remainder % primes.get(i) == 0) remainder /= primes.get(i);
		}
		if (remainder > 1) primes.add(nextNum);
	}
	
	public static void generatePrimes(ArrayList<Long> primes, long maxNum) {
		primes.clear();
		getPrimes(primes, 2);
		for (long i = 3; i < maxNum; i += 8) {
			getPrimes(primes, i);
			getPrimes(primes, i + 2);
			getPrimes(primes, i + 4);
		}
	}
}
