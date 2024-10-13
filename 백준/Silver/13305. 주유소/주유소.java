import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        distances = new int[n - 1];
        prices = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int n;
    static int[] distances, prices;

    public static void main(String[] args) throws Exception {
        input();

        int tmpDistance = 0;
        int result = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            tmpDistance += distances[i - 1];
            int price = prices[i];
            if (price < min) {
                result += min * tmpDistance;
                min = price;
                tmpDistance = 0;
            }
        }
        if (tmpDistance != 0) {
            result += min * tmpDistance;
        }
        System.out.println(result);
    }
}
