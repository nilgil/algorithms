import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        results = new int[N + 1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(results[i]).append('\n');
        }
        System.out.println(sb);
    }

    static int count = 1;

    private static void dfs(int node) {
        visited[node] = true;
        results[node] = count++;

        graph[node].sort(Comparator.reverseOrder());
        for (int near : graph[node]) {
            if (!visited[near]) {
                dfs(near);
            }
        }
    }
}
