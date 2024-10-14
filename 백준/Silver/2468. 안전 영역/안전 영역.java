import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
				minHeight = Math.min(minHeight, map[i][j]);
			}
		}
	}

	static int[] dX = new int[] {-1, 1, 0, 0};
	static int[] dY = new int[] {0, 0, -1, 1};
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int maxHeight = Integer.MIN_VALUE;
	static int minHeight = Integer.MAX_VALUE;
	static int result = 0;

	static int currentHeight;
	static int currentCount;

	public static void main(String[] args) throws Exception {
		input();

		for (currentHeight = 0; currentHeight <= maxHeight; currentHeight++) {
			currentCount = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (currentHeight < map[i][j] && !visited[i][j]) {
						currentCount++;
						dfs(i, j);
					}
				}
			}
			result = Math.max(result, currentCount);
		}

		System.out.println(result);
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];
			if (nX < 0 || n <= nX || nY < 0 || n <= nY || visited[nX][nY] || map[nX][nY] <= currentHeight) {
				continue;
			}
			visited[nX][nY] = true;
			dfs(nX, nY);
		}
	}
}
