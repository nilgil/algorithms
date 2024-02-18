import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[10000];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[num - 1]++;
        }
        br.close();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                bw.write(i + 1 + "");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}