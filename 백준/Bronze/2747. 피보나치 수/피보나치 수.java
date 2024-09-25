import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    static int[] cache = new int[46];

    static int fibonacci(int num) {
        if (num == 2 || num == 1) {
            return 1;
        }
        if (cache[num] != 0) {
            return cache[num];
        }
        cache[num] = fibonacci(num - 1) + fibonacci(num - 2);
        return cache[num];
    }
}