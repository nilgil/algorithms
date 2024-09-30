import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = line.length();
        int[] counts = new int[10];
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            counts[c - '0'] = counts[c - '0'] + 1;
        }

        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            int count = counts[i];
            max = Math.max(max, count);
        }
        int sixAndNine = counts[6] + counts[9];
        int half = sixAndNine % 2 == 0 ? sixAndNine / 2 : sixAndNine / 2 + 1;
        max = Math.max(max, half);
        System.out.println(max);
    }
}
