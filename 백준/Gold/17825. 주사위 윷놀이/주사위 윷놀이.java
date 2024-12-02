import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int score;
		boolean isEmpty;
		boolean isFinish;
		Node next;
		Node shortcut;

		public Node(int score) {
			this.score = score;
			this.isEmpty = true;
			this.next = null;
			this.shortcut = null;
			this.isFinish = false;
		}
	}

	static Node start = new Node(0);
	static Node center = new Node(25);
	static Node end = new Node(40);
	static Node finish = new Node(0);

	private static void init() {
		center.next = new Node(30);
		center.next.next = new Node(35);
		center.next.next.next = end;

		end.next = finish;
		finish.isFinish = true;
		finish.next = finish;

		Node tmp = start;

		for (int i = 1; i <= 19; i++) {
			if (tmp.score == 10) {
				tmp.shortcut = new Node(13);
				tmp.shortcut.next = new Node(16);
				tmp.shortcut.next.next = new Node(19);
				tmp.shortcut.next.next.next = center;
			} else if (tmp.score == 20) {
				tmp.shortcut = new Node(22);
				tmp.shortcut.next = new Node(24);
				tmp.shortcut.next.next = center;
			} else if (tmp.score == 30) {
				tmp.shortcut = new Node(28);
				tmp.shortcut.next = new Node(27);
				tmp.shortcut.next.next = new Node(26);
				tmp.shortcut.next.next.next = center;
			}
			Node next = new Node(i * 2);
			tmp.next = next;
			tmp = next;
		}
		tmp.next = end;
	}

	static int[] dices;
	static int[] dp;
	static Node[] piece;

	public static void main(String[] args) throws IOException {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = 10;
		dices = new int[n + 1];
		dp = new int[n + 1];
		piece = new Node[5];
		for (int i = 1; i <= n; i++) {
			dices[i] = Integer.parseInt(st.nextToken());
		}
		recursive(1);
		System.out.println(result);
	}

	static int result = 0;

	private static void recursive(int depth) {
		if (depth > 10) {
			result = Math.max(result, getTotalScore());
			return;
		}
		for (int j = 1; j <= 4; j++) {
			dp[depth] = j;
			recursive(depth + 1);
		}
	}

	private static int getTotalScore() {
		Arrays.fill(piece, start);
		int score = 0;
		for (int i = 1; i <= 10; i++) {
			int currentPieceNumber = dp[i];
			Node node = piece[currentPieceNumber];
			node.isEmpty = true;
			for (int j = 1; j <= dices[i]; j++) {
				if (j == 1 && node.shortcut != null) {
					node = node.shortcut;
				} else {
					node = node.next;
				}
			}
			piece[currentPieceNumber] = node;
			if (!node.isEmpty && !node.isFinish) {
				score = 0;
				break;
			}
			node.isEmpty = false;
			score += node.score;
		}
		for (int i = 1; i <= 4; i++) {
			piece[i].isEmpty = true;
		}
		return score;
	}
}
