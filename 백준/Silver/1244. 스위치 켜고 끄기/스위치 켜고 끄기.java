import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		boolean[] switches = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			switches[i] = st.nextToken().equals("1");
		}

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				for (int i = number; i <= n; i += number) {
					switches[i] = !switches[i];
				}
			} else {
				switches[number] = !switches[number];
				int i = 1;
				while (number - i >= 1 && number + i <= n && switches[number - i] == switches[number + i]) {
					switches[number - i] = !switches[number - i];
					switches[number + i] = !switches[number + i];
					i++;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(switches[i] ? 1 : 0).append(' ');
			if (i % 20 == 0) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
