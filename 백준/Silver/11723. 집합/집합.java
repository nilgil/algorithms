import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] s = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a = 0; // 20 bit 공간이 필요하기에 32 bit인 int형 사용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int operand;
            switch (operation) {
                case "add":
                    operand = Integer.parseInt(st.nextToken());
                    a = a | (1 << operand);
                    break;
                case "remove":
                    operand = Integer.parseInt(st.nextToken());
                    a = a & ~(1 << operand);
                    break;
                case "toggle":
                    operand = Integer.parseInt(st.nextToken());
                    if (0 < (1 << operand & a)) {
                        a = a & ~(1 << operand);
                    } else {
                        a = a | (1 << operand);
                    }
                    break;
                case "check":
                    operand = Integer.parseInt(st.nextToken());
                    if (0 < (1 << operand & a)) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "all":
                    a = a | (1 << 21) - 1;
                    break;
                case "empty":
                    a = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}