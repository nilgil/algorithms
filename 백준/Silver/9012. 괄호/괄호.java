import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            sb.append(isVPS(line)).append('\n');
        }
        System.out.println(sb);
    }

    private static String isVPS(String line) {
        char[] chars = line.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                count++;
            } else if (count < 1) {
                return "NO";
            } else {
                count--;
            }
        }
        return count == 0 ? "YES" : "NO";
    }
}