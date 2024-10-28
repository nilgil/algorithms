import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int n, m;
	static boolean[] check = new boolean[20_000_001];

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int numIdx = Integer.parseInt(st.nextToken()) + 10_000_000;
			check[numIdx] = true;
		}

		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int numIdx = Integer.parseInt(st.nextToken()) + 10_000_000;
			if (check[numIdx]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append(' ');
		}

		System.out.println(sb);
	}
}
