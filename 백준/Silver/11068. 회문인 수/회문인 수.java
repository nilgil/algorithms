import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean flag = false;
            int n = Integer.parseInt(br.readLine());
            for (int i = 2; i <= 64; i++) {
                if (test(n, i)) {
                    sb.append(1).append('\n');
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static boolean test(int n, int b) {
        int head = 0;
        int[] nums = new int[(int) (Math.sqrt(n) + 1)];
        while (0 < n) {
            int remainder = n % b;
            if (remainder < 10) {
                nums[head++] = remainder + '0';
            } else {
                nums[head++] = remainder - 10 + 'A';
            }
            n /= b;
        }

        for (int i = 0; i < head / 2; i++) {
            if (nums[i] != nums[head - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
