import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


public class Problem65Test {

	@Test
	public void test() {
		double[] testCont = {3, 8/3., 11/4., 19/7., 8/32., 106/39., 193/71., 1264/465., 1457/536.};

		for (int i = 0; i < 9; i ++) {
			BigInteger[] x = Problem65.getCont(i + 1);
			Double a = Double.valueOf(String.valueOf(x[0]));
			Double b = Double.valueOf(String.valueOf(x[1]));
			if (a / b != testCont[i]) {
				fail(String.valueOf(i));
			}
		}
		if (Problem65.solve(9) != 17) {
			fail("Example failed");
		}
	}
}
