import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static final int LENGTH = 15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] apart = new int[LENGTH][LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            apart[i][1] = 1;
            apart[0][i] = i;
        }

        for (int i = 1; i < LENGTH; i++) {
            for (int j = 2; j < LENGTH; j++) {
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
            }
        }

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apart[k][n]);
        }
    }
}