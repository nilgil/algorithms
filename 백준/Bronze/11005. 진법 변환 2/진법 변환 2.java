import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int head = 0;
        int[] nums = new int[100];
        while (0 < n) {
            if (n % b < 10) {
                nums[head++] = n % b + '0';
            } else {
                nums[head++] = n % b - 10 + 'A';
            }
            n /= b;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = head - 1; i >= 0; i--) {
            sb.append((char) nums[i]);
        }
        System.out.println(sb);
    }
}
