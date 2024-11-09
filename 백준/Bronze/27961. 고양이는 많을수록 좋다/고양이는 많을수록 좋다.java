import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if (n <= 1) {
			System.out.println(n);
			return;
		}

		int count = 1;
		long tmp = 1;
		while (tmp < n) {
			tmp *= 2;
			count++;
		}
		System.out.println(count);
	}
}
