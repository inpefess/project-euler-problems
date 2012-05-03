import java.util.ArrayList;

public class Problem241 {
	public static long solve () {
		ArrayList<Long> primes = new ArrayList<Long>(1000000);
		int r = 15499;
		int d = 94744;
		for (long nextNum = 2; nextNum < 1000000; nextNum ++) {
			long remainder = nextNum;
			long phi = nextNum;
			for (int i = 0; i < primes.size() && remainder > 1; i ++) {
				if (remainder % primes.get(i) == 0) {
					phi = (phi * (primes.get(i) - 1)) / primes.get(i);
				}
				while (remainder % primes.get(i) == 0)
				{
					remainder /= primes.get(i);
				}
			}
			if (remainder > 1) {
				primes.add(nextNum);
				phi = nextNum - 1;
			}
			if 	(phi * d < r * (nextNum - 1)) return nextNum;
		}
		return 0;
	}
}