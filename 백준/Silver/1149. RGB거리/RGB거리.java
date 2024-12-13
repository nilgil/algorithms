import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] costs = new int[n][3];
		int[][] dp = new int[n][3];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][RED] = costs[0][RED];
		dp[0][GREEN] = costs[0][GREEN];
		dp[0][BLUE] = costs[0][BLUE];

		for (int i = 1; i < n; i++) {
			dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + costs[i][RED];
			dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + costs[i][GREEN];
			dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + costs[i][BLUE];
		}

		int result = Math.min(Math.min(dp[n - 1][RED], dp[n - 1][GREEN]), dp[n - 1][BLUE]);
		System.out.println(result);
	}
}
