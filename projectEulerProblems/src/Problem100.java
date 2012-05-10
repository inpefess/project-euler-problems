public class Problem100 {
	public static long solve (long n) {
		for (long total = n; ; total ++) {
			double rnd = 0.5 * (1.0 + Math.sqrt(2.0 * (double) total * (double) total - 2.0 * (double) total + 1.0));
			long min = (long) (rnd * 0.999999999) - 1;
			long max = (long) (rnd * 1.000000001) + 1;
			for (long blue = min; blue <= max ; blue ++) {
				if ((total * (total - 1) % (blue * (blue - 1)) == 0)) {
					if ((total * (total - 1) / (blue * (blue - 1)) == 2)) {
							return blue;
					}
				}
			}
		}
	}
}