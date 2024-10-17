import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int getBlackCount() {
		int black = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j]) {
					black++;
				}
			}
		}
		return black;
	}

	private static void fill(int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				map[i][j] = true;
			}
		}
	}

	static int n;
	static boolean[][] map = new boolean[100][100];

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getBlackCount());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			fill(x, y);
		}
	}
}
