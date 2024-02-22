import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(lastCard(n));
    }

    private static int lastCard(int n) {
        int i = 0;
        while (true) {
            int pow = (int) Math.pow(2, i);
            if (pow < n) {
                i++;
            } else {
                return pow - (pow - n) * 2;
            }
        }
    }
}