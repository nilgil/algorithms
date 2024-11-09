import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		if (n <= 1) {
			System.out.println(n);
			return;
		}
		dfs(1, 1);
		System.out.println(min);
	}

	static int min = Integer.MAX_VALUE;

	private static void dfs(long cats, int count) {
		if (n < cats) {
			return;
		}
		if (n <= cats + cats) {
			min = Math.min(min, count + 1);
			return;
		}
		dfs(cats * 2, count + 1);
	}
}
