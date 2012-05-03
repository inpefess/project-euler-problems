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
		String filename = "test_matrix.txt";
		int n = 5;
		long[][] matrix = new long[n][n];
		readMatrix(matrix, filename, n, n);
		return 0;
	}
}
