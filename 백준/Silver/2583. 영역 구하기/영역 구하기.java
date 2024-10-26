import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int[] dX = new int[] {-1, 1, 0, 0};
	static int[] dY = new int[] {0, 0, -1, 1};

	static int m, n, k;
	static boolean[][] paper;
	static boolean[][] visited;
	static int bound, size;
	static List<Integer> sizes = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!paper[i][j] && !visited[i][j]) {
					bound++;
					dfs(i, j);
					sizes.add(size);
					size = 0;
				}
			}
		}
		sizes.sort(Integer::compareTo);
		sb.append(bound).append('\n');
		sizes.forEach(size -> sb.append(size).append(' '));
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		if (paper[x][y] || visited[x][y]) {
			return;
		}
		size++;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];
			if (0 <= nX && nX < m && 0 <= nY && nY < n) {
				dfs(nX, nY);
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		paper = new boolean[m][n];
		visited = new boolean[m][n];

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					paper[i][j] = true;
				}
			}
		}
	}
}
