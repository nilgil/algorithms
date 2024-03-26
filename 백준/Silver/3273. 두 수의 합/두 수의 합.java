import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] exist = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            exist[Integer.parseInt(st.nextToken())] = true;
        }
        int x = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i < x - i; i++) {
            if (i <= 1000000 && exist[i] && x - i <= 1000000 && exist[x - i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}