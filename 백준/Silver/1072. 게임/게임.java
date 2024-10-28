import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int x, y, z;

	public static void main(String[] args) throws Exception {
		input();
		int result = -1;
		int l = 0;
		int r = x;
		while (l <= r) {
			int m = (l + r) / 2;
			if (z < calculatePercent(x + m, y + m)) {
				result = m;
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		System.out.println(result);
	}

	private static int calculatePercent(int x, int y) {
		return (int)((long)y * 100 / x);
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		z = calculatePercent(x, y);
	}
}
