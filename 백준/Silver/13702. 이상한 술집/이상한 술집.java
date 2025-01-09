import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] pots;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pots = new int[N];
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			pots[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, pots[i]);
		}

		Arrays.sort(pots);

		long l = 0;
		long r = max;
		long result = 0;
		while (l <= r) {
			long m = (l + r) / 2;
			boolean b = canDivide(m);
			if (b) {
				result = m;
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean canDivide(long m) {
		if (m == 0)
			return true;
		long sum = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (pots[i] / m > 0) {
				sum += pots[i] / m;
			} else {
				break;
			}
			if (sum >= K) {
				return true;
			}
		}
		return false;
	}
}
