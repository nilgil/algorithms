import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int number = 666;
        while (true) {
            String strNum = String.valueOf(number);
            if (strNum.contains("666")) {
                if (++count == n) {
                    System.out.println(strNum);
                    return;
                }
            }
            number++;
        }
    }
}