import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int[] dX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dY = {0, 0, -1, 1, 1, -1, 1, -1};

    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        while (w != 0 && h != 0) {
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(count).append('\n');

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nX = x + dX[i];
            if (nX < 0 || h <= nX) {
                continue;
            }
            int nY = y + dY[i];
            if (nY < 0 || w <= nY) {
                continue;
            }
            if (!visited[nX][nY] && map[nX][nY] == 1) {
                bfs(nX, nY);
            }
        }
    }
}
