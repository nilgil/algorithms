import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] ropes;

    public static void main(String[] args) throws Exception {
        input();

        Arrays.sort(ropes);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ropes.length; i++) {
            max = Math.max(max, ropes[i] * (ropes.length - i));
        }

        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
    }
}
