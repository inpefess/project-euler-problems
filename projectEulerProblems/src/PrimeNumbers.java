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
		primes.clear();
		Boolean[] seed = new Boolean[1];
	}
	
	public static void loadPrimes(ArrayList<Integer> primes, int maxNum, String fileName) {
		try{
			BufferedReader fin = new BufferedReader(new FileReader(fileName));
			for (int i = 0; i < maxNum; i ++) {
				primes.add(Integer.valueOf(fin.readLine()));
			}
			fin.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
