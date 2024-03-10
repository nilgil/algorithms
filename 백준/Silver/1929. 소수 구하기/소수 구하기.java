import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] notPrimes = new boolean[n + 1];
        notPrimes[0] = notPrimes[1] = true;

        for (int i = 2; i <= Math.sqrt(notPrimes.length); i++) {
            if (notPrimes[i]) {
                continue;
            }
            for (int j = i * i; j < notPrimes.length; j += i) {
                notPrimes[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!notPrimes[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}