import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] timeTable = {4, 6, 4, 10};
	static int n;
	static Map<String, Integer> workMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					String name = st.nextToken();
					if (name.equals("-")) {
						continue;
					}
					workMap.put(name, workMap.getOrDefault(name, 0) + timeTable[i]);
				}
			}
		}

		if (workMap.isEmpty()) {
			System.out.println("Yes");
			return;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (Integer value : workMap.values()) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		}
		System.out.println(max - min <= 12 ? "Yes" : "No");
	}
}
