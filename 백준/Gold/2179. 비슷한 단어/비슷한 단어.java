import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> words = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			arr[i] = word;
			words.put(word, words.getOrDefault(word, i));
		}
		List<String> sorted = words.keySet().stream()
			.sorted(String::compareTo)
			.collect(Collectors.toList());

		int s = -1;
		int t = -1;

		int maxCount = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int count = samePrefixCount(sorted.get(i), sorted.get(j));
				if (maxCount < count) {
					maxCount = count;
					Integer idx1 = words.get(sorted.get(i));
					Integer idx2 = words.get(sorted.get(j));
					s = Math.min(idx1, idx2);
					t = Math.max(idx1, idx2);
				} else if (maxCount == count) {
					Integer idx1 = words.get(sorted.get(i));
					Integer idx2 = words.get(sorted.get(j));
					int min = Math.min(idx1, idx2);
					int max = Math.max(idx1, idx2);
					if (min < s) {
						s = min;
						t = max;
					} else if (min == s && max < t) {
						t = max;
					}
				} else {
					break;
				}
			}
		}
		System.out.println(arr[s]);
		System.out.println(arr[t]);
	}

	private static int samePrefixCount(String s1, String s2) {
		int loopCount = Math.min(s1.length(), s2.length());
		int sameCount = 0;
		for (int i = 0; i < loopCount; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (c1 == c2) {
				sameCount++;
			} else {
				break;
			}
		}
		return sameCount;
	}
}
