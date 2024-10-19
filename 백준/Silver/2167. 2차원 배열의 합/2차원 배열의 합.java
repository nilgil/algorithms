import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int n, m, k;
	static int[][] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken()) +
					nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1];
			}
		}

		k = Integer.parseInt(br.readLine());
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = nums[x][y];
			int b = nums[i - 1][y];
			int c = nums[x][j - 1];
			int d = nums[i - 1][j - 1];
			int result = a - b - c + d;
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}
