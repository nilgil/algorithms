import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int fibCount, fibonacciCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);
		System.out.println(fibCount + " " + fibonacciCount);
	}

	private static int fib(int n) {
		if (n == 1 || n == 2) {
			fibCount++;
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	private static int fibonacci(int n) {
		int[] dp = new int[n + 1];
		dp[1] = dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			fibonacciCount++;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
