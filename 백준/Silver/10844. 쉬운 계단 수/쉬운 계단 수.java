import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n + 1][10];
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			dp[i][0] = mod(dp[i - 1][1]);
			dp[i][9] = mod(dp[i - 1][8]);
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = mod(mod(dp[i - 1][j - 1]) + mod(dp[i - 1][j + 1]));
			}
		}
		long sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum = mod(sum + dp[n][i]);
		}
		System.out.println(sum);
	}

	private static long mod(long num) {
		return num % MOD;
	}
}
