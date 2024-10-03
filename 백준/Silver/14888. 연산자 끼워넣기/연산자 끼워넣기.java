import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operations.length; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] operations = new int[4];

    private static void recursive(int depth, int result) {
        if (depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        } else {
            for (int i = 0; i < 4; i++) {
                if (1 <= operations[i]) {
                    operations[i]--;
                    recursive(depth + 1, calculate(result, nums[depth], i));
                    operations[i]++;
                }
            }
        }
    }

    private static int calculate(int operand1, int operand2, int operation) {
        if (operation == 0) {
            return operand1 + operand2;
        } else if (operation == 1) {
            return operand1 - operand2;
        } else if (operation == 2) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        recursive(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }
}
