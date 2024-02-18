import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] nums = new boolean[2_000_001]; // -1_000_000 ~ 1_000_000 -> 0의 위치 = [1_000_000]
        for (int i = 0; i < n; i++) {
            nums[Integer.parseInt(br.readLine()) + 1_000_000] = true;
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]) {
                bw.write((i - 1_000_000) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}