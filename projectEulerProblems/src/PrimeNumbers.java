import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PrimeNumbers {

	public static Boolean isPrime (int n) {
		for (int i = 2; i < n; i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void writePrimes(int maxNumber, String fileName) {
		try{
			BufferedWriter fout = new BufferedWriter(new FileWriter(fileName));
			ArrayList<Integer> primes = new ArrayList<Integer>(maxNumber);
			generatePrimes(primes, maxNumber);
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
	
	public static void generatePrimes(ArrayList<Integer> primes, int maxNumber) {
		boolean[] sieve = new boolean[maxNumber];
		for (int i = 0; i < maxNumber; i ++) {
			sieve[i] = true;
		}		
		for (int i = 2; i < maxNumber; i ++) {
			if (sieve[i]) {
				for (int j = 2 * i; j < maxNumber; j += i) {
					sieve[j] = false;
				}
			}
		}
		primes.clear();
		for (int i = 2; i < maxNumber; i ++) {
			if (sieve[i]) primes.add(i);
		}
	}
	
	public static void loadPrimes(ArrayList<Integer> primes, int maxNum, String fileName) {
		try{
			BufferedReader fin = new BufferedReader(new FileReader(fileName));
			for (int i = 0; i < maxNum; i ++) {
				String line = fin.readLine();
				if (line != null) primes.add(Integer.valueOf(line));
			}
			fin.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
