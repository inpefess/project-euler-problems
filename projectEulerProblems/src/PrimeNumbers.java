import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PrimeNumbers {
	public static final String fileName = "PrimeNumbers.txt";
	public static final int maxNumber = 100000; 

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
			BufferedWriter fout = new BufferedWriter(new FileWriter(fileName));
			ArrayList<Long> primes = new ArrayList<Long>(maxNumber);
			generatePrimes(primes);
			for (int i = 0; i < primes.size(); i ++) {
				fout.write(String.valueOf(primes.get(i)));
				fout.write(System.getProperty("line.separator"));
			}
			fout.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void getPrimes(ArrayList<Long> primes, long nextNum) {
		Boolean isPrime = true;
		for (int i = 0; i < primes.size() && isPrime; i ++) {
			isPrime = nextNum % primes.get(i) != 0;
		}
		if (isPrime) primes.add(nextNum);
	}
	
	public static void generatePrimes(ArrayList<Long> primes) {
		primes.clear();
		getPrimes(primes, 2);
		int percent = 0;
		for (int i = 3; primes.size() < maxNumber; i += 2) {
			if ((primes.size() * 100) / maxNumber > percent) {
				percent ++;
				System.out.println(percent);
				System.out.println(i);
			}
			getPrimes(primes, i);
		}
	}
	
	public static void loadPrimes(ArrayList<Long> primes) {
		try{
			BufferedReader fin = new BufferedReader(new FileReader(fileName));
			for (int i = 0; i < maxNumber; i ++) {
				primes.add(Long.valueOf(fin.readLine()));
			}
			fin.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
