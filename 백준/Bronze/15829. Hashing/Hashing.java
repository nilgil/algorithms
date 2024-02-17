import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static final int R = 31;
    public static final int M = 1234567891;
    public static final int ALP_PREVIOUS_ASCII = 96;
    public static List<Integer> rs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String alps = br.readLine();

        long result = 0;
        long pow = 1;
        for (int i = 0; i < l; i++) {
            int alpNum = alps.charAt(i) - ALP_PREVIOUS_ASCII;
            result += (alpNum * pow);
            pow = (pow * R) % M;
        }
        System.out.println(result % M);
    }
}