import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static String[] colors = new String[] {"black", "brown", "red", "orange",
		"yellow", "green", "blue", "violet", "grey", "white"};

	public static void main(String[] args) throws IOException {
		Map<String, long[]> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(colors[i], new long[] {i, (int)Math.pow(10, i)});
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long result = (map.get(br.readLine())[0] * 10 + map.get(br.readLine())[0]) * map.get(br.readLine())[1];
		System.out.println(result);
	}
}
