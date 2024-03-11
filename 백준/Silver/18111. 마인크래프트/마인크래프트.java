import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int resultSec = Integer.MAX_VALUE;
        int resultHeight = Integer.MIN_VALUE;

        for (int i = min; i <= max; i++) {
            int tmp = b;
            int sec = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int height = map[j][k];
                    if (height < i) {
                        sec += i - height;
                        tmp -= i - height;
                    } else if (height > i) {
                        sec += (height - i) * 2;
                        tmp += height - i;
                    }
                }
            }
            if (tmp < 0) {
                continue;
            }
            if (sec < resultSec) {
                resultSec = sec;
                resultHeight = i;
            } else if (sec == resultSec) {
                resultHeight = Math.max(resultHeight, i);
            }
        }
        System.out.printf("%d %d", resultSec, resultHeight);
    }
}