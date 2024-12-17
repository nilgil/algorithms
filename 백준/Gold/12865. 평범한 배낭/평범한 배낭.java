import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Thing {
		int weight;
		int value;

		public Thing(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Thing[] things = new Thing[n + 1];
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			things[i] = new Thing(weight, value);
		}

		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= k; w++) {
				Thing thing = things[i];
				if (w < thing.weight) {
					dp[i][w] = dp[i - 1][w];
				} else {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - thing.weight] + thing.value);
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
