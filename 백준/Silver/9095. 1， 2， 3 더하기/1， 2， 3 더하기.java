import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(find(0));
        }
    }

    static int find(int i) {
        if (i == n) {
            return 1;
        } else if (i < n) {
            return find(i + 1) + find(i + 2) + find(i + 3);
        } else {
            return 0;
        }
    }
}