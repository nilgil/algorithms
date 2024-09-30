import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        check = new int[100_001];
        bfs(n);
    }

    static int next;

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        check[start] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = now * 2;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = now - 1;
                }
                if (next == k) {
                    System.out.println(check[now]);
                    return;
                }
                if (0 <= next && next < check.length && check[next] == 0) {
                    queue.offer(next);
                    check[next] = check[now] + 1;
                }
            }
        }
    }
}
