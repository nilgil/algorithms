import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[][] dp = new int[k + 1][2];
		dp[0] = new int[] {1, 0};
		for (int i = 1; i <= k; i++) {
			dp[i] = new int[] {dp[i - 1][1], dp[i - 1][0] + dp[i - 1][1]};
		}
		System.out.println(dp[k][0] + " " + dp[k][1]);
	}
}