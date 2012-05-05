import java.util.ArrayList;

public class Problem243 {
	public static ArrayList<Integer> eulerPhi;
	
	public static int solve (int maxNum, int r, int d) {
		eulerPhi = new ArrayList<Integer>(maxNum);
		ArrayList<Integer> primes = new ArrayList<Integer>(maxNum);
		PrimeNumbers.loadPrimes(primes, maxNum, "PrimeNumbers.txt");
		eulerPhi.clear();
		for (int nextNum = 2; nextNum < maxNum; nextNum ++) {
			int phi = 1;
			int k = primes.get(0);
			int reminder = nextNum;
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