import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp = new Integer[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(find(n));
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = (find(n - 2) + find(n - 1)) % 10007;
        }
        return dp[n];
    }
}