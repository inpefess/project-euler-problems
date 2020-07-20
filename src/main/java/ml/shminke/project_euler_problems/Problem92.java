package ml.shminke.project_euler_problems;

public class Problem92 {
	private static int digitSquareSum(int j) {
		String line = String.valueOf(j);
		int k = 0;
		for (int i = 0; i < line.length(); i ++) {
			int m = Integer.valueOf(String.valueOf(line.charAt(i)));
			k += m * m;
		}
		return k;
	}
	
	public static int solve () {
		int n = 0;
		int percent = 0;
		for (int i = 2; i < 10000000; i ++) {
			if (i / 10000 > percent) {
				percent ++;
				System.out.println(percent);
			}
			int j;
			for(j = i; j != 1 && j != 89; j = digitSquareSum(j));
			if (j == 89) n ++;
		}
		return n;
	}
}
