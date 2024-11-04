import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m;
	static Map<String, String> scoreMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String title = st.nextToken();
			String pre = String.format("%s %s %s", st.nextToken(), st.nextToken(), st.nextToken());
			scoreMap.put(pre, scoreMap.getOrDefault(pre, "") + " " + title);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(scoreMap.getOrDefault(br.readLine(), ""));
			int count = st.countTokens();
			if (count == 1) {
				sb.append(st.nextToken());
			} else if (count == 0) {
				sb.append('!');
			} else {
				sb.append('?');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}
