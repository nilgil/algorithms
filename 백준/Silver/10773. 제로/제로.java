import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int head = 0;
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                nums[head++] = num;
            } else {
                head--;
            }
        }

        long sum = 0;
        for (int i = 0; i < head; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
    }
}