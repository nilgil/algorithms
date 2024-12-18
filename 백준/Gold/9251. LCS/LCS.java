import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[] aChars, bChars;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		aChars = br.readLine().toCharArray();
		bChars = br.readLine().toCharArray();
		dp = new int[aChars.length + 1][bChars.length + 1];
		for (int[] nums : dp) {
			Arrays.fill(nums, -1);
		}
		System.out.println(lcs(aChars.length - 1, bChars.length - 1));
	}

	private static int lcs(int a, int b) {
		if (a < 0 || b < 0) {
			return 0;
		}
		if (dp[a][b] == -1) {
			if (aChars[a] == bChars[b]) {
				dp[a][b] = lcs(a - 1, b - 1) + 1;
			} else {
				dp[a][b] = Math.max(lcs(a - 1, b), lcs(a, b - 1));
			}
		}
		return dp[a][b];
	}
}
