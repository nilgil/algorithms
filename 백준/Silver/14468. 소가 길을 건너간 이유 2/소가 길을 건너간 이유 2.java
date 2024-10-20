import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] in = new int[26];
	static int[] out = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] records = br.readLine().toCharArray();
		for (int i = 1; i <= 52; i++) {
			int index = records[i - 1] - 'A';
			if (in[index] == 0) {
				in[index] = i;
			} else {
				out[index] = i;
			}
		}
		int count = 0;
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < out.length; j++) {
				if (in[i] < in[j] && in[j] < out[i] && out[i] < out[j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
