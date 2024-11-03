package algorithm.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Bfs {

    static int n;
    static int[][] graph;
    static boolean[] visited;

    static void queueBfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            // some for output
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
