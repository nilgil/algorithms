import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            minSix = Math.min(minSix, six);
            minOne = Math.min(minOne, one);
        }
    }

    static int n, m;
    static int minSix = Integer.MAX_VALUE;
    static int minOne = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();

        if (minOne * 6 < minSix) {
            System.out.println(n * minOne);
            return;
        }
        if (minSix < n % 6 * minOne) {
            System.out.println((n / 6 + 1) * minSix);
        } else {
            System.out.println(n / 6 * minSix + n % 6 * minOne);
        }
    }
}
