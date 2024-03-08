import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(levels);

        int without = (int) Math.round(n * 15 / 100.0);

        int sum = 0;
        for (int i = without; i < levels.length - without; i++) {
            int level = levels[i];
            sum += level;
        }

        System.out.println(Math.round(sum / (double) (levels.length - without * 2)));
    }
}