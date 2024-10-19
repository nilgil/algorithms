import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수열에서 k개의 연속된 수 합이 가장 큰 값을 구하라.
 * 누적합을 구하며 시작 후 k번째가 될 때까지 그냥 더한다.
 * k번째 부터는 현재 누적합에 (i - k)번째 누적합을 빼서 k개의 합을 구한다.
 * 계속 진행하며 k값의 합 최대값을 구한다.
 * */
public class Main {

	static int n, k, max = Integer.MIN_VALUE;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nums = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
			if (k <= i) {
				int gap = nums[i] - nums[i - k];
				max = Math.max(max, gap);
			}
		}
		System.out.println(max);
	}
}
