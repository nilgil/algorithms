import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int m, n;
    static int[][] box;
    static Queue<Position> targets = new LinkedList<>();

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    targets.offer(new Position(i, j));
                }
            }
        }

        while (!targets.isEmpty()) {
            Position now = targets.poll();
            for (int i = 0; i < 4; i++) {
                int nX = now.x + dX[i];
                int nY = now.y + dY[i];
                if (0 <= nX && nX < n && 0 <= nY && nY < m) {
                    if (box[nX][nY] == 0) {
                        targets.add(new Position(nX, nY));
                        box[nX][nY] = box[now.x][now.y] + 1;
                    }
                }
            }
        }

        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, box[i][j]);
            }
        }
        System.out.println(day - 1);
    }
}
