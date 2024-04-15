import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static int[][] board;
    static int n;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        initBoard();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n && board[i][j] != board[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    updateMax();
                    swap(i, j, i + 1, j);
                }
                if (j + 1 < n && board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    updateMax();
                    swap(i, j, i, j + 1);
                }
            }
        }
        System.out.println(max);
    }

    private static void initBoard() throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        int tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    private static void updateMax() {
        for (int i = 0; i < n; i++) {
            int rowMax = 1;
            int colMax = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    rowMax++;
                    max = Math.max(max, rowMax);
                } else {
                    rowMax = 1;
                }
                if (board[j][i] == board[j + 1][i]) {
                    colMax++;
                    max = Math.max(max, colMax);
                } else {
                    colMax = 1;
                }
            }
        }
    }
}
