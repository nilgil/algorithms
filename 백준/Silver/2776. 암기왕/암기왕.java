import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());
			int[] note1 = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(note1);

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				int target = Integer.parseInt(st.nextToken());
				sb.append(binarySearch(note1, target)).append('\n');
			}

		}

		System.out.println(sb);
	}

	private static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				return 1;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return 0;
	}
}
