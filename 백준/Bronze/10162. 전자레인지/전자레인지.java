import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int t;
	static int a = 0, b = 0, c = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		if (t % 10 != 0) {
			System.out.println(-1);
			return;
		}
		while (t > 0) {
			if (t >= 300) {
				t -= 300;
				a++;
			} else if (t >= 60) {
				t -= 60;
				b++;
			} else {
				t -= 10;
				c++;
			}
		}
		System.out.printf("%d %d %d", a, b, c);
	}
}
