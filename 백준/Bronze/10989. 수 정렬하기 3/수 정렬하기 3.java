import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static final int NUMS_RANGE = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[NUMS_RANGE];
        for (int i = 0; i < n; i++) {
            nums[Integer.parseInt(br.readLine()) - 1]++;
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < NUMS_RANGE; i++) {
            for (int j = 0; j < nums[i]; j++) {
                bw.write(i + 1 + "");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}