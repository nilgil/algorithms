import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[] ices = new int[1_000_001];
	static int minIdx = Integer.MAX_VALUE;
	static int maxIdx = Integer.MIN_VALUE;
	static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		input();
		int currentSum = 0;
		for (int i = minIdx; i <= maxIdx; i++) {
			int window = k * 2 + 1;
			if (window <= i) {
				currentSum -= ices[i - window];
			}
			currentSum += ices[i];
			maxSum = Math.max(maxSum, currentSum);
		}
		System.out.println(maxSum);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ices[x] = g;
			maxIdx = Math.max(maxIdx, x);
			minIdx = Math.min(minIdx, x);
		}
	}
}
