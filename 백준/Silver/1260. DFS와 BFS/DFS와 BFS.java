import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, v;
    static int[][] matrix;
    static boolean[] visited;
    static StringBuilder result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        matrix = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }

        visited = new boolean[n + 1];
        result = new StringBuilder();
        dfs(v);
        System.out.println(result);

        visited = new boolean[n + 1];
        result = new StringBuilder();
        bfs(v);
        System.out.println(result);
    }

    static void dfs(int node) {
        visited[node] = true;
        result.append(node).append(" ");

        for (int i = 1; i <= n; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            result.append(now).append(" ");
            for (int i = 1; i <= n; i++) {
                if (matrix[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}