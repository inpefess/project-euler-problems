package asEasyAsPi;
import general.PrimeNumbers;

public class Problem46 {
	public static int solve () {
		for (int n = 3; n < 1000000; n += 2) {
			if (!PrimeNumbers.isPrime(n)) {
				int m = 1;
				int k = 2 * m * m;
				while (n > k) {
					if (PrimeNumbers.isPrime(n - k)) m = n;
					m ++;
					k = 2 * m * m;
				}
				if (m < n) return n;
			}
		}
		return 0;
	}
}
