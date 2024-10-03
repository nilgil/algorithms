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
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
        used = new boolean[10];
    }

    static int n, m;
    static int[] selected;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        input();

        recursive(1);

        System.out.println(sb);
    }

    private static void recursive(int depth) {
        if (depth == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                if (used[i]) {
                    continue;
                }

                selected[depth] = i;
                used[i] = true;

                recursive(depth + 1);

                selected[depth] = 0;
                used[i] = false;
            }
        }
    }
}
