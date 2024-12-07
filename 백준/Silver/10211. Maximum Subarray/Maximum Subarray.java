import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n;
		int[] arr;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			int max = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				int now = Integer.parseInt(st.nextToken());
				arr[i] = Math.max(now, arr[i - 1] + now);
				max = Math.max(max, arr[i]);
			}
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}
}