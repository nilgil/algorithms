import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] sensors = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensors);
		int[] gaps = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			gaps[i] = sensors[i + 1] - sensors[i];
		}
		Arrays.sort(gaps);
		int sum = 0;
		for (int i = 0; i < n - k; i++) {
			sum += gaps[i];
		}
		System.out.println(sum);
	}
}
