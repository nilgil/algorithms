import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
    }

    static int n, k;
    static int[] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();

        System.out.println(search(0));
    }

    static int depth = 0;

    private static int search(int num) {
        if (num == k) {
            return depth;
        }
        if (visited[num]) {
            return -1;
        }
        visited[num] = true;
        depth++;
        return search(map[num]);
    }

}
