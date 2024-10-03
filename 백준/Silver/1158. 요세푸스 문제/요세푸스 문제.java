import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int current = k - 1;
        sb.append('<').append(nums[current]);
        System.arraycopy(nums, current + 1, nums, current, --n - current);
        while (n > 0) {
            current = (current + k - 1) % n;
            sb.append(',').append(' ').append(nums[current]);
            System.arraycopy(nums, current + 1, nums, current, --n - current);
        }
        sb.append('>');
        System.out.println(sb);
    }
}
