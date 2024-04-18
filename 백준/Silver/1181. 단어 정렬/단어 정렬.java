import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (o1, o2) ->
            o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append('\n');
        for (int i = 1; i < n; i++) {
            if (!words[i - 1].equals(words[i])) {
                sb.append(words[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
