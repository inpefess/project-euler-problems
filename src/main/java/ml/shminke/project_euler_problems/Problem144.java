package ml.shminke.project_euler_problems;

public class Problem144 {
	public static int solve () {
		int count = 0;
		double x = 1.4;
		double y = -9.6;
		double a = 1.4 - 0;
		double b = -9.6 - 10.1;
		double nx = 4 * x;
		double ny = y;
		double lambda = (a * nx + b * ny) / (nx * nx + ny * ny);
		a -= 2 * (a - lambda * nx);
		b -= 2 * (b - lambda * ny);
		for (; x > 0.01 || x < -0.01 || y < 0;) {
			count ++;
			double t = - (8 * a * x + 2 * y * b) / (4 * a * a + b * b);
			x += a * t;
			y += b * t;
			nx = 4 * x;
			ny = y;
			lambda = (a * nx + b * ny) / (nx * nx + ny * ny);
			a -= 2 * (a - lambda * nx);
			b -= 2 * (b - lambda * ny);
		}
		return count;
	}
}
