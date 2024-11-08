import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] dX = new int[] {1, 0, -1, 0, 0, 0};
	static int[] dY = new int[] {0, 1, 0, -1, 0, 0};
	static int[] dZ = new int[] {0, 0, 0, 0, 1, -1};
	
	static int n, m, h;
	static int[][][] box;
	static Queue<Tomato> ripeTomatoes = new LinkedList<>();

	static class Tomato {
		int x;
		int y;
		int z;

		public Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					int day = box[i][j][k];
					if (day == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, day);
				}
			}
		}
		System.out.println(max - 1);
	}

	private static void bfs() {
		while (!ripeTomatoes.isEmpty()) {
			Tomato ripeTomato = ripeTomatoes.poll();
			for (int i = 0; i < 6; i++) {
				int nX = ripeTomato.x + dX[i];
				int nY = ripeTomato.y + dY[i];
				int nZ = ripeTomato.z + dZ[i];
				if (nX < 0 || n <= nX || nY < 0 || m <= nY || nZ < 0 || h <= nZ) {
					continue;
				}
				if (box[nZ][nX][nY] == 0) {
					ripeTomatoes.offer(new Tomato(nX, nY, nZ));
					box[nZ][nX][nY] = box[ripeTomato.z][ripeTomato.x][ripeTomato.y] + 1;
				}
			}
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[h][n][m];
		for (int z = 0; z < h; z++) {
			for (int x = 0; x < n; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 0; y < m; y++) {
					box[z][x][y] = Integer.parseInt(st.nextToken());
					if (box[z][x][y] == 1) {
						ripeTomatoes.offer(new Tomato(x, y, z));
					}
				}
			}
		}
	}
}
