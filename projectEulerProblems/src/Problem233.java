public class Problem233 {
	public static long f_ (long N) {
		long M = 3 * N / 2;
		long count = 0;
		for (long i = 0; i < N; i ++) {
			for (long j = N; j < M; j ++) {
				if (i * i + j * j == N * (i + j)) {
					count++;
				}
			}
		}
		return 4 * count;
	}
	
	public static long f (long N) {
		long M = N / 2;
		long count = 0;
		long x = 0;
		long y = N;
		long sum = x * (x - N) + y * (y - N);
		for (; x < M; x ++) {
			if (sum == 0) {
				count ++;
			}
			sum += 2 * x + 1 - N;
			if (sum < 0) {
				sum += 2 * y + 1 - N;
				y ++;
			}
		}
		return 8 * count - 4;
	}	

	public static long solve (long n) {
		long count = 0;
		int percent = 0;
		for (long i = 1; i < n; i ++) {
			if ((i * 100) / n > percent) {
				percent ++;
				System.out.println(percent);
			}
			if (f(i) == 420) count ++;
		}
		return count ++;
	}
}