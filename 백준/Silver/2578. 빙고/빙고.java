import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] idx = new int[26];
	static int[][] board = new int[5][5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				idx[board[i][j]] = i * 5 + j;
			}
		}
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[idx[num] / 5][idx[num] % 5] = 0;
				if (isBingo()) {
					System.out.println(i * 5 + j + 1);
					return;
				}
			}
		}
	}

	private static boolean isBingo() {
		int count = 0;
		count += rowCheck();
		count += colCheck();
		count += rightCrossCheck();
		count += leftCrossCheck();
		return 3 <= count;
	}

	private static int leftCrossCheck() {
		int calledCount = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][i] == 0) {
				calledCount++;
			}
		}
		return calledCount / 5;
	}

	private static int rightCrossCheck() {
		int calledCount = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][5 - i - 1] == 0) {
				calledCount++;
			}
		}
		return calledCount / 5;
	}

	private static int rowCheck() {
		int lineCount = 0;
		for (int i = 0; i < 5; i++) {
			int calledCount = 0;
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == 0) {
					calledCount++;
				}

			}
			lineCount += calledCount / 5;
		}
		return lineCount;
	}

	private static int colCheck() {
		int lineCount = 0;
		for (int i = 0; i < 5; i++) {
			int calledCount = 0;
			for (int j = 0; j < 5; j++) {
				if (board[j][i] == 0) {
					calledCount++;
				}
			}
			lineCount += calledCount / 5;
		}
		return lineCount;
	}
}
