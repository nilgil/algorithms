import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] buckets = new int[n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int l = i; l <= j; l++) {
				buckets[l] = k;
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(buckets[i]).append(' ');
		}
		System.out.println(sb);
	}
}
