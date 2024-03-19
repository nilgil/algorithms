import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[] protectedRow = new boolean[n];
        boolean[] protectedCol = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') {
                    protectedRow[i] = true;
                    protectedCol[j] = true;
                }
            }
        }

        int unprotectedRowCount = n;
        for (int i = 0; i < n; i++) {
            if (protectedRow[i]) {
                unprotectedRowCount--;
            }
        }
        int unprotectedColCount = m;
        for (int i = 0; i < m; i++) {
            if (protectedCol[i]) {
                unprotectedColCount--;
            }
        }

        System.out.println(Math.max(unprotectedRowCount, unprotectedColCount));
    }
}
