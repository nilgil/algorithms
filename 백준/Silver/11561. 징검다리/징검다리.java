import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long result = 0;
			long n = Long.parseLong(br.readLine());
			long l = 0;
			long r = (long)Math.sqrt(2 * n - 1);
			while (l <= r) {
				long m = (l + r) / 2;
				long sum = m * (m + 1) / 2;
				if (sum <= n) {
					result = m;
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}
