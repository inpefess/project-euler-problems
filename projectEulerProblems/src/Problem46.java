
public class Problem46 {
	public static long solve () {
		for (long n = 3; n < PrimeNumbers.maxNumber; n += 2) {
			if (!PrimeNumbers.isPrime(n)) {
				long m = 1;
				long k = 2 * m * m;
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
