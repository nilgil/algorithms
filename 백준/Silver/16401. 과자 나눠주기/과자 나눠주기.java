import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] sticks;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		sticks = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sticks[i] = Integer.parseInt(st.nextToken());
		}

		int l = 1;
		int r = 1_000_000_000;
		int result = 0;
		while (l <= r) {
			int c = (l + r) / 2;
			if (canDivide(c)) {
				result = c;
				l = c + 1;
			} else {
				r = c - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean canDivide(int length) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (sticks[i] < length) {
				continue;
			}
			count += sticks[i] / length;
			if (count >= M) {
				return true;
			}
		}
		return false;
	}
}
