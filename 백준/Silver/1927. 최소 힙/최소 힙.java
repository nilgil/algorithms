import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Queue<Integer> operator = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (operator.isEmpty()) {
					sb.append("0");
				} else {
					sb.append(operator.poll());
				}
				sb.append('\n');
			} else {
				operator.offer(num);
			}
		}
		System.out.println(sb);
	}
}
