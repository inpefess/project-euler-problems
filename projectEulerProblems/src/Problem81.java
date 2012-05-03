import java.io.BufferedReader;
import java.io.FileReader;

public class Problem81 {
	
	private static void readMatrix (long[][] matrix, String filename, int m, int n) {
		try{
			BufferedReader fin = new BufferedReader(new FileReader(filename));
			for (int i = 0; i < m; i ++) {
				String[] line = fin.readLine().split(",");
				for (int j = 0; j < n; j ++) {
					matrix[i][j] = Long.valueOf(line[j]);
				}
			}
			fin.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}		
	}

	public static long solve () {
		String filename = "matrix.txt";
		int n = 80;
		long[][] matrix = new long[n][n];
		readMatrix(matrix, filename, n, n);
		long[][] mmatrix = new long[n][n];
		mmatrix[0][0] = matrix[0][0];
		for (int i = 1; i < n; i ++) {
			mmatrix[i][0] = mmatrix[i - 1][0] + matrix[i][0];
			mmatrix[0][i] = mmatrix[0][i - 1] + matrix[0][i];
		}
		for (int i = 1; i < 2 * n; i ++) {
			int j = i - n + 1;
			if (j < 1) j = 1;
			for (; j < i && j < n; j ++) {
				if (mmatrix[j - 1][i - j] > mmatrix[j][i - j - 1])
					mmatrix[j][i - j] = mmatrix[j][i - j - 1] + matrix[j][i - j];
				else
					mmatrix[j][i - j] = mmatrix[j - 1][i - j] + matrix[j][i - j];
			}
		}
		return mmatrix[n - 1][n - 1];
	}
}
