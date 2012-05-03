import java.util.ArrayList;

public class Problem47 {
	public static long solve () {
		ArrayList<Long> primes = new ArrayList<Long>(1000000);
		int maxNum = 4;
		int[] seq = new int[maxNum];
		int pos = 0;
		for (long nextNum = 2; nextNum < 1000000; nextNum ++) {
			long remainder = nextNum;
			seq[pos] = 0;
			for (int i = 0; i < primes.size() && remainder > 1; i ++) {
				if (remainder % primes.get(i) == 0) {
					seq[pos] ++;
				}
				while (remainder % primes.get(i) == 0)
				{
					remainder /= primes.get(i);
				}
			}
			if (remainder > 1) primes.add(nextNum);
			remainder = 1;
			for (int i = 0; i < maxNum; i ++) {
				if (seq[i] != maxNum) remainder = 0;
			}
			if (remainder == 1) return nextNum - maxNum + 1;
			pos = (pos + 1) % maxNum;
		}
		return 0;
	}
}
