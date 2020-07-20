package ml.shminke.project_euler_problems;

public class Problem44 {
	public static int getPentagonal(int n) {
		return (3 * n - 1) * n / 2; 
	}
	
	public static Boolean isPentagonal(int n) {
		int m = 1;
		int k = 1;
		while (n >= k) {
			if (n == k) return true;
			k += 3 * m + 1;
			m++;
		}
		return false;
	}
	
	public static int solve () {
		int a = 1;
		for (int m = 1; m < 1000000; m++) {
			int b = 1;
			for (int n = 1; n < m; n++) {
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
