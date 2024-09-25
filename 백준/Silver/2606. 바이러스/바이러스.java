import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [DFS/BFS] BJ-2606 바이러스
 * - 노드의 수는 100 이하인 양의 정수이다.
 * - 간선의 방향성과 가중치는 없다.
 * - 1번 노드와 연결된 모든 노드의 수를 구해라.
 */
public class Main {

    static int n, m, count = 0;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = true;
            graph[to][from] = true;
        }

//        recursiveDfs(1);
//        stackDfs(1);
        queueBfs(1);
        
        System.out.println(count);
    }

    static void recursiveDfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] && !visited[i]) {
                count++;
                recursiveDfs(i);
            }
        }
    }

    static void stackDfs(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            Integer now = stack.pop();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }

    static void queueBfs(int node) {
        Queue<Integer> stack = new ArrayDeque<>();
        stack.offer(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            Integer now = stack.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] && !visited[i]) {
                    stack.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}
