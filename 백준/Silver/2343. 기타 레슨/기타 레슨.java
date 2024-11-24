import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] lectures;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int l = 0;
		int r = 0;
		lectures = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			l = Math.max(l, lectures[i]);
			r += lectures[i];
		}


		while (l <= r) {
			int mid = (l + r) / 2;
			int count = getCount(mid);
			if (count <= m) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(l);
	}

	private static int getCount(int length) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (sum + lectures[i] > length) {
				count++;
				sum = lectures[i];
			} else {
				sum += lectures[i];
			}
		}
		return sum != 0 ? count + 1 : count;
	}
}
