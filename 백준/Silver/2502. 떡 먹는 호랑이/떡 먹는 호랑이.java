import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] first = new int[d + 1];
		int[] second = new int[d + 1];
		first[3] = 1;
		second[3] = 1;
		if (d > 3) {
			first[4] = 1;
			second[4] = 2;
			for (int i = 5; i <= d; i++) {
				first[i] = first[i - 2] + first[i - 1];
				second[i] = second[i - 2] + second[i - 1];
			}
		}

		int a = first[d];
		int b = second[d];

		for (int i = 1; i <= 100000; i++) {
			if ((k - i * a) % b == 0) {
				System.out.println(i);
				System.out.println((k - i * a) / b);
				return;
			}
		}
	}
}
