import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        topScores = new double[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                double score = Double.parseDouble(st.nextToken());
                topScores[num] = Math.max(topScores[num], score);
            }
        }
    }

    static int n, m, k;
    static double[] topScores;

    public static void main(String[] args) throws Exception {
        input();

        Arrays.sort(topScores);

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += topScores[n - i];
        }


        System.out.println(Math.round(sum * 10) / 10.0);
    }
}
