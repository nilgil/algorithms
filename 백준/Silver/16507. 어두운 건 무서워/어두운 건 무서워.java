import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2차원 배열에서의 누적합을 구한다.
 * 오른쪽 아래 꼭지점에 대한 누적합에서 좌측, 상측 영역에 대한 누적합을 빼준다.
 * 좌상측 공통 부분에 대해 누적합을 더해준다.
 * */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int r, c, q;
	static int[][] picture;

	public static void main(String[] args) throws Exception {
		input();
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int sum = picture[r2][c2] + picture[r1 - 1][c1 - 1]
				- picture[r2][c1 - 1] - picture[r1 - 1][c2];
			int cellCount = (r2 - r1 + 1) * (c2 - c1 + 1);
			sb.append(sum / cellCount).append('\n');
		}
		System.out.println(sb);
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		picture = new int[r + 1][c + 1];
		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= c; j++) {
				picture[i][j] = picture[i - 1][j] + picture[i][j - 1]
					- picture[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
	}
}
