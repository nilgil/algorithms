import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static long[] trees;

	public static void main(String[] args) throws Exception {
		input();

		long l = 0;
		long r = 1_000_000_000;
		long result = -1;
		while (l <= r) {
			long c = (l + r) / 2;
			long sum = 0;
			for (int i = 0; i < n; i++) {
				long height = trees[i];
				if (c < height) {
					sum += height - c;
				}
			}
			if (m <= sum) {
				result = c;
				l = c + 1;
			} else {
				r = c - 1;
			}
		}
		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		trees = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Long.parseLong(st.nextToken());
		}
	}
}
