import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n + 1];
		int[] sums = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sums[i] = sums[i - 1] + nums[i];
		}

		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (long)nums[i] * (sums[n] - sums[i]);
		}
		System.out.println(sum);
	}
}
