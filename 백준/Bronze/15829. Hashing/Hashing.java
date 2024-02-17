import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static final int R = 31;
    public static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            nums.add(((int) chars[i]) - 96);
        }

        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer i1 = nums.get(i);
            int pow = (int) Math.pow(R, i);
            int num = i1 * pow;
            sum += num;
        }
        
        System.out.println(sum % M);
    }
}