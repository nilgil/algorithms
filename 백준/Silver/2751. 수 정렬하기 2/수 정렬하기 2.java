import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] nums = new boolean[2_000_001];
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[Integer.parseInt(br.readLine()) + 1_000_000] = true;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]) {
                sb.append(i - 1_000_000).append("\n");
            }
        }
        System.out.println(sb);
    }
}