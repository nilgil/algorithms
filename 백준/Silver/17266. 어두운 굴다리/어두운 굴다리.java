import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] lights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lights = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCover(mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static boolean canCover(int height) {
        int before = 0;
        for (int i = 0; i < M; i++) {
            int point = lights[i];
            if (point - before > height) {
                return false;
            }
            before = point + height;
        }
        return N - before <= 0;
    }
}
