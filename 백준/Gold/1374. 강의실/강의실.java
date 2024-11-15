import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static Queue<Integer> ends = new PriorityQueue<>();
	static int n;
	static Lecture[] lectures;

	static class Lecture implements Comparable<Lecture> {
		int id;
		int start;
		int end;

		public Lecture(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			return start != o.start ? Integer.compare(start, o.start) : Integer.compare(end, o.end);
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		int maxSize = 0;
		for (int i = 0; i < n; i++) {
			Lecture lecture = lectures[i];
			while (!ends.isEmpty() && ends.peek() <= lecture.start) {
				ends.poll();
			}
			ends.offer(lecture.end);
			maxSize = Math.max(maxSize, ends.size());
		}
		System.out.println(maxSize);
	}

	private static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		lectures = new Lecture[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(id, start, end);
		}
		Arrays.sort(lectures);
	}
}
