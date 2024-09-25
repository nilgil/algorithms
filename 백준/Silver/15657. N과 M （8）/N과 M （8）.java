import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] nums;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        check = new boolean[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        perm(0, 0);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    static void perm(int depth, int before) {
        // base case
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursive case
        for (int i = 0; i < n; i++) {
            if (before <= nums[i]) {
                output[depth] = nums[i];
                perm(depth + 1, output[depth]);
            }
        }
    }
}