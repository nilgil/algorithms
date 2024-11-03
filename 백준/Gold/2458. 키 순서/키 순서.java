import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static boolean[][] connects;

	public static void main(String[] args) throws Exception {
		input();

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (connects[i][k] && connects[k][j]) {
						connects[i][j] = true;
					}
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (connects[i][j] || connects[j][i]) {
					sum++;
				}
			}
			if (sum == n - 1) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		connects = new boolean[n + 1][n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connects[a][b] = true;
		}
	}
}
