import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k < 0 || k > n) {
            System.out.println(0);
            return;
        }

        int nFac = 1;
        for (int i = n; i > n - k; i--) {
            nFac *= i;
        }
        int kFac = 1;
        for (int i = k; i > 0; i--) {
            kFac *= i;
        }
        System.out.println(nFac / kFac);
    }
}