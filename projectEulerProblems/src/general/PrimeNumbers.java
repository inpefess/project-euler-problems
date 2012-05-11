package general;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PrimeNumbers {
	private boolean[] sieve;
	private int sieveSize;
	private int currentPos;
	
	public PrimeNumbers() {
		sieve = new boolean[]{false, false, true};
		sieveSize = 3;
		currentPos = 2;
	}

	public static Boolean isPrime (int n) {
		for (int i = 2; i < n; i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void writePrimes(String fileName) {
		try{
			BufferedWriter fout = new BufferedWriter(new FileWriter(fileName));
			goToFirstPrime();
			for (int k = getNextPrime(); k != 0; k = getNextPrime()) {
				fout.write(String.valueOf(k));
				fout.write(System.getProperty("line.separator"));
			}
			fout.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void generatePrimes(int maxNumber) {
		sieve = new boolean[maxNumber];
		sieveSize = maxNumber;
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
		currentPos = 2;
	}
	
	public void goToFirstPrime() {
		currentPos = 2;
	}
	
	public int getNextPrime() {
		for (int i = currentPos; i < sieveSize; i ++) {
			if (sieve[i]) {
				currentPos = i + 1;
				return i;
			}
		}
		return 0;
	}
	
	public void loadPrimes(int maxNumber, String fileName) {
		try{
			BufferedReader fin = new BufferedReader(new FileReader(fileName));
			sieve = new boolean[maxNumber];
			sieveSize = maxNumber;
			for (int i = 0; i < maxNumber; i ++) {
				sieve[i] = false;
			}
			String line = "";
			int prime = 2;
			for (; line != null && prime < maxNumber;) {
				line = fin.readLine();
				if (line != null) {
					prime = Integer.valueOf(line);
					sieve[prime] = true;
				}
			}
			fin.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
