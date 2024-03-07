import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        while (!line.equals(".")) {
            sb.append(solve(line)).append('\n');
            line = br.readLine();
        }
        System.out.println(sb);
    }

    private static String solve(String line) {
        int head = 1;
        char[] stack = new char[line.length() + 1];
        for (char ch : line.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack[head++] = ch;
            } else if (ch == ')') {
                if (stack[head - 1] != '(') {
                    return "no";
                }
                head--;
            } else if (ch == ']') {
                if (stack[head - 1] != '[') {
                    return "no";
                }
                head--;
            }
        }
        if (head != 1) {
            return "no";
        }
        return "yes";
    }
}