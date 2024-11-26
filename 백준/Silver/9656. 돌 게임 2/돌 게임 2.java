import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
		}
		System.out.println(dp[n] % 2 == 0 ? "SK" : "CY");
	}
}