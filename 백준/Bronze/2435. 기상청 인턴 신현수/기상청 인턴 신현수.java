import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[] nums;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nums = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
		}
		for (int i = k; i <= n; i++) {
			max = Math.max(max, nums[i] - nums[i - k]);
		}
		System.out.println(max);
	}
}
