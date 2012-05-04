import java.util.ArrayList;

public class Problem243 {
	public static int maxNum = 1299709;
	public static ArrayList<Long> eulerPhi = new ArrayList<Long>(1000000);
	
	public static long solve () {
		ArrayList<Long> primes = new ArrayList<Long>(PrimeNumbers.maxNumber);
		PrimeNumbers.loadPrimes(primes);
		eulerPhi.clear();
		int r = 15499;
		int d = 94744;
		int percent = 0;
		for (long nextNum = 2; nextNum < maxNum; nextNum ++) {
			if ((nextNum * 100) / maxNum > percent) {
				percent ++;
				System.out.println(percent);
			}
			long phi = 1;
			long k = primes.get(0);
			long reminder = nextNum;
			for (int i = 0; i < primes.size() && k <= reminder; i ++) {
				k = primes.get(i);
				Boolean first = true;
				while (reminder % k == 0) {
					if (first) first = false;
					else phi *= k;
					reminder /= k;
				}
				if (!first) phi *= k - 1;
			}
			eulerPhi.add(phi);
			if 	(phi * d < r * (nextNum - 1)) return nextNum;
		}
		return 0;
	}
}