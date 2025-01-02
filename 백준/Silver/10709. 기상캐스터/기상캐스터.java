import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[h+1][w+1];
		for (int i = 1; i <= h; i++) {
			String line = br.readLine();
			for (int j = 1; j <= w; j++) {
				map[i][j] = line.charAt(j - 1) == 'c';
			}
		}

		int before;
		for (int i = 1; i <= h; i++) {
			before = -1;
			for (int j = 1; j <= w; j++) {
				int next;
				if (map[i][j]) {
					next = 0;
				} else if (before >= 0) {
					next = before + 1;
				} else {
					next = -1;
				}
				before = next;
				sb.append(next).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
