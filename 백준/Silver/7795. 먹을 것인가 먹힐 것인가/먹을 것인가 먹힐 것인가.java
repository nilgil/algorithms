import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			int[] b = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);

			int sum = 0;
			for (int i = 0; i < n; i++) {
				int l = 0;
				int r = m - 1;
				int idx = 0;
				while (l <= r) {
					int c = (l + r) / 2;
					if (b[c] < a[i]) {
						l = c + 1;
						idx = l;
					} else {
						r = c - 1;
					}
				}
				sum += idx;
			}
			System.out.println(sum);
		}

	}
}
