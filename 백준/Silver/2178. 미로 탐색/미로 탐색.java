import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [BFS] BJ-2178 빙산 (1초/192MB)
 * <br>- 2차원 배열에서 특정 지점에서 특정 지점까지의 칸 수 구하라.
 * <br>- 갈 수 있는 길이 있고 없는 길이 있다.
 * <br>- 시작 칸과 도착 칸의 수도 포함한다.
 *
 * <br>+ 2차원 배열 초기화
 * <br>+ BFS로 상하좌우 이동 시도 (갈 수 없는 칸이거나 이미 들린칸은 제외)
 * <br>+ 다음칸 큐에 넣을 때 현재 칸까지 오는 횟수 + 1로 map 값 변경하기
 */
public class Main {

    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (cell.x == n - 1 && cell.y == m - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nX = cell.x + dX[i];
                int nY = cell.y + dY[i];
                if (0 <= nX && nX <= n - 1 && 0 <= nY && nY <= m - 1 && map[nX][nY] == 1 && !visited[nX][nY]) {
                    queue.offer(new Cell(nX, nY));
                    visited[nX][nY] = true;
                    map[nX][nY] = map[cell.x][cell.y] + 1;
                }
            }
        }
        return map[n - 1][m - 1];
    }

    static class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}