import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dX = {-1, 1, 0, 0};
	static int[] dY = {0, 0, -1, 1};
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] visitedWithBreak;
	static Queue<Node> queue = new LinkedList<>();

	static class Node {
		int x;
		int y;
		int distance;
		boolean broke;

		public Node(int x, int y, int distance, boolean broke) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.broke = broke;
		}
	}

	private static void bfs() {
		visited[1][1] = true;
		queue.offer(new Node(1, 1, 1, false));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.x == n && node.y == m) {
				System.out.println(node.distance);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nX = node.x + dX[i];
				int nY = node.y + dY[i];
				int nD = node.distance + 1;
				if (nX < 1 || n < nX || nY < 1 || m < nY) {
					continue;
				}

				// 다음 칸이 벽이면
				if (map[nX][nY] == 1) {
					if (!node.broke) {
						visitedWithBreak[nX][nY] = true;
						queue.offer(new Node(nX, nY, nD, true));
					}
				}
				// 다음 칸이 벽이 아니면
				else {
					// 벽을 부순적이 없다면 (같은 경우로 방문했다면 굳이 다시 방문하지 않음)
					if (!node.broke && !visited[nX][nY]) {
						visited[nX][nY] = true;
						queue.offer(new Node(nX, nY, nD, false));
					}
					// 벽을 부순적이 있다면 (같은 경우로 방문했다면 굳이 다시 방문하지 않음)
					else if (node.broke && !visitedWithBreak[nX][nY]) {
						visitedWithBreak[nX][nY] = true;
						queue.offer(new Node(nX, nY, nD, true));
					}
				}
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws Exception {
		input();

		bfs();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		visitedWithBreak = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
	}
}
