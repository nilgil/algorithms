import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int t, m, n, k;
    static boolean[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new boolean[m + 1][n + 1];
            visited = new boolean[m + 1][n + 1];
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = true;
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j] && !visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (!field[x][y]) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nX = x + dX[i];
            int nY = y + dY[i];
            if (0 <= nX && nX < m && 0 <= nY && nY < n
                    && field[nX][nY] && !visited[nX][nY]) {
                dfs(nX, nY);
            }
        }
    }
}
