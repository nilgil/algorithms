import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n + 1];
		int[] dp = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = nums[1];
		for (int i = 1; i <= n; i++) {
			dp[i] = nums[i];
			for (int j = 1; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[j] + nums[i], dp[i]);
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
