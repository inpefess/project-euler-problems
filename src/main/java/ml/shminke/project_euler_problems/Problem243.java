package ml.shminke.project_euler_problems;
import ml.shminke.project_euler_problems.PrimeNumbers;

public class Problem243 {
	public static PrimeNumbers primes;
	
	public static int totientFunction(int n) {
		int phi = 1;
		primes.goToFirstPrime();
		int k;
		int reminder = n;
		for (k = primes.getNextPrime(); k != 0 && k <= reminder; k = primes.getNextPrime()) {
			Boolean first = true;
			while (reminder % k == 0) {
				if (first) first = false;
				else phi *= k;
				reminder /= k;
			}
			if (!first) phi *= k - 1;
		}
		return phi;
	}
	
	public static int solve (int maxNumber, int r, int d) {
		primes = new PrimeNumbers();
		primes.generatePrimes(maxNumber);
		int percent = 0;
		for (int nextNum = 6330000; nextNum < maxNumber; nextNum ++) {
			if (((long) nextNum * 1000) / maxNumber > percent) {
				percent ++;
				System.out.println(nextNum);
			}
			int phi = totientFunction(nextNum);
			if 	((long) phi * (long) d < (long) r * (long) (nextNum - 1)) {
				return nextNum;
			}
		}
		return 0;
	}
}
