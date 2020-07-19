package ml.shminke.project_euler_problems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class Problem65Test {

	@Test
	public void test() {
		double[] testCont = {3, 8/3., 11/4., 19/7., 87/32., 106/39., 193/71., 1264/465., 1457/536.};

		for (int i = 0; i < 9; i ++) {
			BigInteger[] x = Problem65.getCont(i + 1);
			Double a = Double.valueOf(String.valueOf(x[0]));
			Double b = Double.valueOf(String.valueOf(x[1]));
			assertEquals(a / b, testCont[i]);
		}
		assertEquals(Problem65.solve(9), 17);
	}
}
