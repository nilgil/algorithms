import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        limits = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            limits[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int n;
    static int[] limits;

    public static void main(String[] args) throws Exception {
        input();

        Arrays.sort(limits);

        int count = 0;
        for (int i = 0; i < n; i += limits[i]) {
            count++;
        }

        System.out.println(count);
    }
}
