import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * [DFS/BFS] BJ-2573 빙산 (1초/256MB)
 * <br>- 노드의 개수는 10,000개 이하이다. -> 인접 행렬을 사용하면 메모리 초과
 * <br>- 1년이 흘렀을 때 빙산 상,하,좌,우 바다인 개수만큼 녹는다.
 * <br>- 한 덩어리의 빙산이 나뉘어져 2개 이상이 되는 경우 몇 년이 흘렀는지 출력한다.
 * <br>- 나뉘어지지 않은 채 전부 녹으면 0을 출력한다.
 *
 * <br>+ 바다 초기화, 빙산 기록
 * <br>+ 녹은 빙산 마킹
 * <br>+ 바다 빙산 녹이기
 * <br>+ 녹은 빙산 정리
 * <br>+ DFS 분리 덩어리 존재 여부 확인
 */
public class Main {

    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    static int n, m, icebergGroupCount;
    static int[][] sea;
    static List<Iceberg> icebergs;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sea = new int[n][m];
        icebergs = new ArrayList<>();
        visited = new boolean[n][m];

        // 바다 초기화, 빙산 기록
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (0 < sea[i][j]) {
                    icebergs.add(new Iceberg(i, j, sea[i][j]));
                }
            }
        }

        int year = 0;
        while (!icebergs.isEmpty()) {
            year++;

            // 녹은 빙산 마킹
            for (Iceberg iceberg : icebergs) {
                for (int j = 0; j < 4; j++) {
                    int adjX = iceberg.x + dX[j];
                    int adjY = iceberg.y + dY[j];
                    if (sea[adjX][adjY] == 0) {
                        iceberg.z--;
                    }
                }
            }

            // 바다 빙산 녹이기
            for (Iceberg iceberg : icebergs) {
                sea[iceberg.x][iceberg.y] = Math.max(iceberg.z, 0);
            }

            // 녹은 빙산 정리
            icebergs = icebergs.stream()
                    .filter(iceberg -> 0 < sea[iceberg.x][iceberg.y])
                    .collect(Collectors.toList());

            // 분리 덩어리 존재 여부 확인
            if (hasSeperatedGroup()) {
                System.out.println(year);
                return;
            }
        }
        System.out.println(0);
    }

    static boolean hasSeperatedGroup() {
        visited = new boolean[n][m];
        icebergGroupCount = 0;

        boolean foundGroup = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (0 < sea[i][j] && !visited[i][j]) {
                    if (foundGroup) {
                        return true;
                    }
                    dfs(i, j);
                    foundGroup = true;
                }
            }
        }
        return false;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int adjX = x + dX[i];
            int adjY = y + dY[i];
            if (0 < sea[adjX][adjY] && !visited[adjX][adjY]) {
                dfs(adjX, adjY);
            }
        }
    }
}

class Iceberg {
    int x;
    int y;
    int z;

    public Iceberg(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
