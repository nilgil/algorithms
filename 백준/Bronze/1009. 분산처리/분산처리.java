import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = 1;
			for (int i = 0; i < b; i++) {
				result *= a;
				result %= 10;
			}
			if (result == 0) {
				sb.append(10);
			} else {
				sb.append(result);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
