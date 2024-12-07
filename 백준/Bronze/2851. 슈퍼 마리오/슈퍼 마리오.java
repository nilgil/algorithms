import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int TARGET = 100;
	static int n = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tmp = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			tmp = sum;
			sum += Integer.parseInt(br.readLine());
			if (sum == TARGET) {
				System.out.println(sum);
				return;
			}
			if (sum > TARGET) {
				break;
			}
		}
		int result;
		int beforeAbs = Math.abs(TARGET - tmp);
		int afterAbs = Math.abs(TARGET - sum);
		if (beforeAbs < afterAbs) {
			result = tmp;
		} else {
			result = sum;
		}
		System.out.println(result);
	}
}
