import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] children = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			children[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1);

		int maxLength = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (children[j] < children[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		System.out.println(n - maxLength);
	}
}
