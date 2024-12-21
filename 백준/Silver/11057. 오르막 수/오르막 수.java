import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][10];
		Arrays.fill(dp[1], 1);
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = mod(dp[i][j - 1] + dp[i - 1][j]);
			}
		}
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result += dp[n][i];
		}
		System.out.println(mod(result));
	}

	private static int mod(int num) {
		return num % 10_007;
	}
}
