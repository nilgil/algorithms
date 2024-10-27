import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 누적합을 실수 횟수를 기준으로 만들면 된다.
 * */
public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n, q;
	static int[] scorePreFixes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		scorePreFixes = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int before = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= n; i++) {
			int now = Integer.parseInt(st.nextToken());
			scorePreFixes[i] = scorePreFixes[i - 1];
			if (now < before) {
				scorePreFixes[i]++;
			}
			before = now;
		}
		q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(scorePreFixes[y] - scorePreFixes[x]).append('\n');
		}
		System.out.println(sb);
	}
}
