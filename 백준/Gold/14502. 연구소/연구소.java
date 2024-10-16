import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dX = new int[] {-1, 1, 0, 0};
	static int[] dY = new int[] {0, 0, -1, 1};
	static int n, m;
	static int[][] map;
	static int[][] copyMap;
	static Queue<int[]> viruses;
	static int result = Integer.MIN_VALUE;

	private static void dfs(int wallCount) {
		if (wallCount == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wallCount + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		viruses = new LinkedList<>();
		copyMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyMap[i][j] = map[i][j];
				if (copyMap[i][j] == 2) {
					viruses.offer(new int[] {i, j});
				}
			}
		}

		while (!viruses.isEmpty()) {
			int[] virus = viruses.poll();
			for (int i = 0; i < 4; i++) {
				int nX = virus[0] + dX[i];
				int nY = virus[1] + dY[i];
				if (nX < 0 || n <= nX || nY < 0 || m <= nY) {
					continue;
				}
				if (copyMap[nX][nY] == 0) {
					copyMap[nX][nY] = 2;
					viruses.offer(new int[] {nX, nY});
				}
			}
		}

		int safetyCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 0) {
					safetyCount++;
				}
			}
		}
		result = Math.max(result, safetyCount);
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0);
		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
