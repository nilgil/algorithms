import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());

		String[] numbers = new String[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = br.readLine();
		}

		int numberLength = numbers[0].length();
		for (int i = 1; i <= numberLength; i++) {
			for (int j = 0; j < n; j++) {
				String substring = numbers[j].substring(numberLength - i);
				set.add(substring);
			}
			if (set.size() == n) {
				System.out.println(i);
				return;
			}
			set.clear();
		}
	}
}
