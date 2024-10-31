import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] requests;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		input();

		int l = 0;
		int r = max;
		while (l <= r) {
			int c = (l + r) / 2;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += Math.min(requests[i], c);
			}
			if (sum <= m) {
				l = c + 1;
			} else {
				r = c - 1;
			}
		}
		System.out.println(r);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		requests = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			requests[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, requests[i]);
		}
		m = Integer.parseInt(br.readLine());
	}
}
