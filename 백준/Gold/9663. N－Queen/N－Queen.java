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

    private static void recursive(int row) {
        if (row == n + 1) {
            count++;
        } else {
            for (int i = 1; i <= n; i++) {
                // 체크를 로우의 컬럼마다 진행하여 못놓는 곳에 놓는 경우 건너뜀
                if (check(row, i)) {
                    col[row] = i;
                    recursive(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        // 해당 행 이전의 행들을 보고 현재 칸에 놓을 수 있는지 체크
        for (int i = 1; i < r; i++) {
            // col[i]에 각 로우에 어떤 행에 담긴지 기록되어있음
            if (attackable(r, c, i, col[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        // r2가 r1보다 작은게 보장됨
        // 같은 열에 있다면 공격 가능
        if (c1 == c2) {
            return true;
        }

        // 대각선 검사
        if (r1 + c1 == r2 + c2) {
            return true;
        }
        if (r1 - c1 == r2 - c2) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        input();

        recursive(1);

        System.out.println(count);
    }
}
