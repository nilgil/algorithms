import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int count = 0;
		while (0 < n) {
			if (n % 5 == 0) {
				count += n /= 5;
				break;
			} else {
				n -= 2;
				count++;
			}
		}
		System.out.println(n < 0 ? -1 : count);
	}
}
