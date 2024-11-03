package algorithm.graph;

import java.util.Stack;

public class Dfs {

    static int n;
    static int[][] graph;
    static boolean[] visited;

    static void recursiveDfs(int node) {
        visited[node] = true;
        // some for output
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
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
            // some for output
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}
