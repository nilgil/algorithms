import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int result;
	static int towerCount;
	static boolean[][] graph;
	static boolean[] visited;

	public int solution(int n, int[][] wires) {
		result = n;
		towerCount = n;
		graph = new boolean[n + 1][n + 1];
		for (int[] wire : wires) {
			graph[wire[0]][wire[1]] = true;
			graph[wire[1]][wire[0]] = true;
		}
		visited = new boolean[n + 1];

		for (int[] wire : wires) {
			int avoidA = wire[0];
			int avoidB = wire[1];

			graph[avoidA][avoidB] = false;
			graph[avoidB][avoidA] = false;

			result = Math.min(result, bfs(avoidA));

			graph[avoidA][avoidB] = true;
			graph[avoidB][avoidA] = true;
		}

		return result;
	}

	private int bfs(int start) {
		visited = new boolean[towerCount + 1];
		int count = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			visited[now] = true;
			for (int i = 1; i <= towerCount; i++) {
				if (!visited[i] && graph[now][i]) {
					queue.offer(i);
					count++;
				}
			}
		}
		return Math.abs(towerCount - 2 * count);
	}
}