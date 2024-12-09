import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int maxStartIdx = -1;
		int maxEndIdx = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (max < num) {
				max = num;
				maxStartIdx = i;
				maxEndIdx = i;
			} else if (max == num) {
				maxEndIdx = i;
			}
		}
		int redCount = maxStartIdx;
		int blueCount = n - maxEndIdx - 1;
		if (redCount < blueCount) {
			System.out.println("R");
		} else if (redCount == blueCount) {
			System.out.println("X");
		} else {
			System.out.println("B");
		}
	}
}
