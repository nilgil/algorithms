import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        calculated = new int[n];
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
    static int[] nums, calculated;
    static int[] operations = new int[4];

    private static void recursive(int depth) {
        if (depth == n) {
            max = Math.max(max, calculated[n - 1]);
            min = Math.min(min, calculated[n - 1]);
        } else {
            for (int i = 0; i < 4; i++) {
                if (hasOperator(i)) {
                    continue;
                }
                calculate(depth, i);
                operations[i]--;

                recursive(depth + 1);

                calculated[depth] = 0;
                operations[i]++;
            }
        }
    }

    private static boolean hasOperator(int i) {
        return operations[i] <= 0;
    }

    private static void calculate(int depth, int i) {
        if (i == 0) {
            calculated[depth] = calculated[depth - 1] + nums[depth];
        } else if (i == 1) {
            calculated[depth] = calculated[depth - 1] - nums[depth];
        } else if (i == 2) {
            calculated[depth] = calculated[depth - 1] * nums[depth];
        } else {
            calculated[depth] = calculated[depth - 1] / nums[depth];
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        calculated[0] = nums[0];
        recursive(1);

        System.out.println(max);
        System.out.println(min);
    }
}
