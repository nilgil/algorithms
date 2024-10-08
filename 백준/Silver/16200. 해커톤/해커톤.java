import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        counts = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int n;
    static int[] counts;

    public static void main(String[] args) throws Exception {
        input();

        Arrays.sort(counts);

        int team = 0;
        for (int i = 0; i < n; i++) {
            int now = counts[i];
            i = i + now - 1;
            team++;
        }
        System.out.println(team);
    }
}
