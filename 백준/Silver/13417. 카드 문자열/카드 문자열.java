import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t, n;
	static Deque<String> deque;

	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			deque = new ArrayDeque<>();
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (n-- > 0) {
				String character = st.nextToken();
				if (deque.isEmpty()) {
					deque.add(character);
					continue;
				}
				if (deque.peekFirst().compareTo(character) >= 0) {
					deque.addFirst(character);
				} else {
					deque.addLast(character);
				}
			}
			for (String s : deque) {
				sb.append(s);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
