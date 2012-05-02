
public class Problem44 {
	public static long getPentagonal(long n) {
		return (3 * n - 1) * n / 2; 
	}
	
	public static Boolean isPentagonal(long n) {
		long m = 1;
		long k = 1;
		while (n >= k) {
			if (n == k) return true;
			k += 3 * m + 1;
			m++;
		}
		return false;
	}
	
	public static long solve () {
		long a = 1;
		for (long m = 1; m < 1000000; m++) {
			long b = 1;
			for (long n = 1; n < m; n++) {
				if (isPentagonal(a + b)) {
					if (isPentagonal(a + 2 * b)) return a;
					if (isPentagonal(2 * a + b)) return b;
				}
				b += 3 * n + 1;
			}
			a += 3 * m + 1;
		}
		return 0;
	}
}
