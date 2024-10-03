import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n + 1];
    }

    static int n, count = 0;
    static int[] col;

    public static void main(String[] args) throws Exception {
        input();

        recursive(1);

        System.out.println(count);
    }

    private static void recursive(int row) {
        if (row == n + 1) {
            count++;
        } else {
            // 한줄 단위 컬럼 순회 놓기
            for (int i = 1; i <= n; i++) {
                // 다음줄 놓기전에 해당 좌표에 놔도 되는지 체크하고 놓기
                if (!available(row, i)) {
                    continue;
                }
                col[row] = i;
                recursive(row + 1);
                col[row] = 0;
            }
        }
    }

    private static boolean available(int r, int c) {
        for (int i = 1; i < r; i++) {
            if (attackable(r, c, i, col[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        return c1 == c2 || r1 - c1 == r2 - c2 || r1 + c1 == r2 + c2;
    }
}
