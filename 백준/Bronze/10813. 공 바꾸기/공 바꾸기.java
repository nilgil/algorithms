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
		for (int i = 1; i <= n; i++) {
			buckets[i] = i;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int tmp = buckets[i];
			buckets[i] = buckets[j];
			buckets[j] = tmp;
		}

		for (int i = 1; i <= n; i++) {
			sb.append(buckets[i]).append(' ');
		}
		System.out.println(sb);
	}
}
