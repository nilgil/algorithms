import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numString = br.readLine();
        int n = Integer.parseInt(numString);
        if (n < 100) {
            System.out.println(n);
            return;
        }

        int count = 99;
        for (int i = 100; i <= n; i++) {
            int i1 = i / 100;
            int i2 = i / 10 % 10;
            int i3 = i % 10;
            if (i1 - i2 == i2 - i3) {
                count++;
            }
        }
        System.out.println(count);
    }
}
