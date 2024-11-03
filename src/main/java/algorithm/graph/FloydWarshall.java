package algorithm.graph;

import java.util.Arrays;

public class FloydWarshall {
	static final int INF = 1000000000;
	static int[][] graph = new int[5][5];

	public static void main(String[] args) {
		for (int[] edges : graph) {
			Arrays.fill(edges, INF);
		}

		// 경유지
		for (int k = 1; k <= graph.length; k++) {
			// 출발지
			for (int i = 1; i <= graph.length; i++) {
				//도착지
				for (int j = 1; j <= graph.length; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}
}
