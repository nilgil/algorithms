import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int n;
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), i);
		}

		int[] record = new int[n];
		for (int i = 0; i < n; i++) {
			record[i] = map.get(br.readLine());
		}

		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (record[j] < record[i]) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
