import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        scores = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = scores[1];

        if (n >= 2) {
            dp[2] = scores[1] + scores[2];
        }

        System.out.println(find(n));
    }

    static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + scores[n - 1]) + scores[n];
        }
        return dp[n];
    }
}