import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] dices = new int[n][6];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int sum = 0;
		int result = 0;
		for (int i = 0; i < 6; i++) {
			int top = dices[0][i];
			int bottom;
			for (int j = 0; j < n; j++) {
				int maxSide = 0;
				for (int currentBottomIdx = 0; currentBottomIdx < 6; currentBottomIdx++) {
					if (top == dices[j][currentBottomIdx]) {
						bottom = top;
						top = dices[j][getParallelSideIndex(currentBottomIdx)];
						maxSide = Math.max(maxSide, getMaxSide(top, bottom));
						break;
					}
				}
				sum += maxSide;
			}
			result = Math.max(result, sum);
			sum = 0;
		}
		
		System.out.println(result);
	}

	private static int getMaxSide(int top, int bottom) {
		for (int i = 6; i >= 1; i--) {
			if (i != top && i != bottom) {
				return i;
			}
		}
		return -1;
	}

	private static int getParallelSideIndex(int i) {
		switch (i) {
			case 0:
				return 5;
			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 1;
			case 4:
				return 2;
			case 5:
				return 0;
			default:
				return -1;
		}
	}
}