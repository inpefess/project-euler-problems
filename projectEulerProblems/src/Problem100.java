public class Problem100 {
	public static long solve (long n) {
		for (long total = n; ; total ++) {
			double rnd = 0.5 * (1 + Math.sqrt(2 * total * total - 2 * total + 1));
			for (long blue = (long) (rnd * 0.9); blue < rnd * 1.1; blue ++)
			if ((total * (total - 1) % (blue % (blue - 1)) == 0) ) {
				return blue;
			}
		}
	}
}
