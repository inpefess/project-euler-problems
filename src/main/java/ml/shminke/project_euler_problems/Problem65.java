package asEasyAsPi;
import java.math.BigInteger;

public class Problem65 {
	public static BigInteger[] contract (BigInteger[] x) {
		BigInteger[] y = new BigInteger[2];
		y[0] = x[0];
		y[1] = x[1];
		for (BigInteger m = new BigInteger("2"); y[0].compareTo(m) >= 1	&& y[1].compareTo(m) >= 1; m = m.add(new BigInteger("2"))) {
			while (y[0].remainder(m) == new BigInteger("0") && y[1].remainder(m) == new BigInteger("0")) {
				y[0] = y[0].divide(m);
				y[1] = y[0].divide(m);
			}
		}
		return y;
	}
	
	public static int digSum(BigInteger n) {
		String line = String.valueOf(n);
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			sum += Integer.valueOf(String.valueOf(line.charAt(i)));
		}
		return sum;
	}
	
	public static BigInteger[] getCont(int n) {
		int[] cont = new int[n + 1];
		BigInteger[] x = new BigInteger[2];
		cont[0] = 2;
		for (int i = 1; i <= n; i ++) {
			cont[i] = 1;
		}
		for (int i = 2; i <= n; i +=3) {
			cont[i] = ((i + 1) / 3) * 2;
		}
		x[0] = new BigInteger(String.valueOf(cont[n]));
		x[1] = new BigInteger(String.valueOf(1));
		for (int i = n - 1; i >= 0; i --) {
			BigInteger z = x[1].add(x[0].multiply(new BigInteger(String.valueOf(cont[i]))));
			x[1] = x[0];
			x[0] = z;
		}
		return x;
	}
	
	public static int solve (int n) {
		BigInteger[] x = contract(getCont(n));
		return digSum(x[0]);
	}
}
