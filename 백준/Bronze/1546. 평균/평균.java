import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static final int R = 31;
    public static final int M = 1234567891;
    public static final int ALP_PREVIOUS_ASCII = 96;
    public static List<Integer> rs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            sum += score;
            max = Math.max(score, max);
        }
        System.out.println(sum * 100.0 / max / n);
    }
}