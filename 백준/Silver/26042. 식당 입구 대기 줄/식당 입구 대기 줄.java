import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		int maxLength = Integer.MIN_VALUE;
		int minStudent = Integer.MAX_VALUE;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if (type == 1) {
				int student = Integer.parseInt(st.nextToken());
				queue.offer(student);
				if (maxLength == queue.size()) {
					minStudent = Math.min(minStudent, student);
				} else if (maxLength < queue.size()) {
					maxLength = queue.size();
					minStudent = student;
				}
			} else {
				queue.poll();
			}
		}
		System.out.println(maxLength + " " + minStudent);
	}
}
