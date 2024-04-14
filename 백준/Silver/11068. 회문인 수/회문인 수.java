import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean isPalindrome = false;
            int n = Integer.parseInt(br.readLine());
            for (int i = 2; i <= 64; i++) {
                int[] digits = new int[20];
                int length = convertBase(n, i, digits);
                if (isPalindrome(digits, length)) {
                    isPalindrome = true;
                    break;
                }
            }
            if (isPalindrome) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int convertBase(int n, int base, int[] digits) {
        int length = 0;
        while (0 < n) {
            digits[length++] = n % base;
            n /= base;
        }
        return length;
    }

    private static boolean isPalindrome(int[] digits, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (digits[i] != digits[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
