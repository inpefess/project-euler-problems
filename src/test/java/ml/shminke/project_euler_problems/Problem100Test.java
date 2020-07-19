package ml.shminke.project_euler_problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Problem100Test {
	@Test
	public void test() {
		assertEquals(Problem100.solve(5), 15);
		assertEquals(Problem100.solve(22), 85);
	}
}
