import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] s = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (!st.hasMoreTokens()) {
                switch (operation) {
                    case "all":
                        all();
                        break;
                    case "empty":
                        empty();
                        break;
                }
                continue;
            }
            int operand = Integer.parseInt(st.nextToken());
            switch (operation) {
                case "add":
                    add(operand);
                    break;
                case "remove":
                    remove(operand);
                    break;
                case "check":
                    sb.append(check(operand)).append('\n');
                    break;
                case "toggle":
                    toggle(operand);
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void add(int operand) {
        s[operand] = true;
    }

    private static void remove(int operand) {
        s[operand] = false;
    }

    private static int check(int operand) {
        return s[operand] ? 1 : 0;
    }

    private static void toggle(int operand) {
        s[operand] = !s[operand];
    }

    private static void all() {
        Arrays.fill(s, true);
    }

    private static void empty() {
        Arrays.fill(s, false);
    }
}