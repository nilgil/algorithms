import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        calculated[0] = nums[0];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operations.length; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int n;
    static int[] nums;
    static int[] calculated;
    static int[] operations = new int[4];
    static List<Integer> results = new ArrayList<>();

    private static void recursive(int depth) {
        if (depth == n) {
            results.add(calculated[n - 1]);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operations[i] <= 0) {
                    continue;
                }
                if (i == 0) {
                    calculated[depth] = calculated[depth - 1] + nums[depth];
                } else if (i == 1) {
                    calculated[depth] = calculated[depth - 1] - nums[depth];
                } else if (i == 2) {
                    calculated[depth] = calculated[depth - 1] * nums[depth];
                } else {
                    calculated[depth] = calculated[depth - 1] / nums[depth];
                }
                operations[i]--;

                recursive(depth + 1);

                calculated[depth] = 0;
                operations[i]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        recursive(1);

        results.sort(Integer::compareTo);
        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }
}
