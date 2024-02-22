import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int expect = Integer.parseInt(st.nextToken());
            if (hasElement(expect)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean hasElement(long expect) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (start + end) / 2;
            if (expect < nums[center]) {
                end = --center;
            } else if (expect > nums[center]) {
                start = ++center;
            } else {
                return true;
            }
        }
        return false;
    }
}