import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = sum(st.nextToken());
        while (st.hasMoreTokens()) {
            result -= sum(st.nextToken());
        }
        System.out.println(result);
    }

    static int sum(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+");
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }
}
