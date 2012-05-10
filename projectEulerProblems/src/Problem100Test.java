import static org.junit.Assert.*;

import org.junit.Test;

public class Problem100Test {

	@Test
	public void test() {
		if (Problem100.solve(5) != 15) {
			fail("15");
		}
		if (Problem100.solve(22) != 85) {
			fail("85");
		}
	}
}
