import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        serials = new String[n];
        for (int i = 0; i < n; i++) {
            serials[i] = br.readLine();
        }
    }

    static int n;
    static String[] serials;

    public static void main(String[] args) throws Exception {
        input();

        Arrays.stream(serials).sorted((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
			int o1Sum = 0;
			int o2Sum = 0;
			for (int i = 0; i < o1.length(); i++) {
				o1Sum += getNum(o1.charAt(i));
				o2Sum += getNum(o2.charAt(i));
			}
			if (o1Sum != o2Sum) {
				return o1Sum - o2Sum;
			}
			return o1.compareTo(o2);
        }).forEach(s -> sb.append(s).append('\n'));

        System.out.println(sb);
    }

    private static int getNum(char c) {
        if ('0' < c && c <= '9') {
            return c - '0';
        }
        return 0;
    }
}
