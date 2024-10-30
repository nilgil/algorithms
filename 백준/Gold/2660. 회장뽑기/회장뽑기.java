import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final int MAX_SCORE = 50;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;
	static int[] scores;
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		input();

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[j][k]);
				}
			}
		}

		int totalMin = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					continue;
				}
				max = Math.max(max, graph[i][j]);
			}
			scores[i] = max;
			totalMin = Math.min(totalMin, max);
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (scores[i] == totalMin) {
				count++;
				sb.append(i).append(' ');
			}
		}

		System.out.printf("%d %d\n", totalMin, count);
		System.out.println(sb);
	}

	private static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		scores = new int[n + 1];
		graph = new int[n + 1][n + 1];
		for (int[] nodes : graph) {
			Arrays.fill(nodes, MAX_SCORE);
		}


		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1) {
				break;
			}
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
	}
}
