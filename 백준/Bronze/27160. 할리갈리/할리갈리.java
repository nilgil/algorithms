import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static Map<String, Integer> cardMap = new HashMap<>();
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String fruit = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			cardMap.put(fruit, cardMap.getOrDefault(fruit, 0) + count);
		}
		boolean match = cardMap.values().stream().anyMatch(integer -> integer == 5);
		System.out.println(match ? "YES" : "NO");
	}
}
