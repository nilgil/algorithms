package algorithm.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BitMask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (st.hasMoreTokens()) {
                int operand = Integer.parseInt(st.nextToken());
                if (operation.charAt(0) == 'a') {
                    a = a | (1 << operand);
                } else if (operation.charAt(0) == 'r') {
                    a = a & ~(1 << operand);
                } else if (operation.charAt(0) == 't') {
                    if (0 < (1 << operand & a)) {
                        a = a & ~(1 << operand);
                    } else {
                        a = a | (1 << operand);
                    }
                } else if (operation.charAt(0) == 'c') {
                    if (0 < (1 << operand & a)) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                }
            } else {
                if (operation.charAt(0) == 'a') {
                    a = a | (1 << 21) - 1;
                } else if (operation.charAt(0) == 'e') {
                    a = 0;
                }
            }
        }
        System.out.println(sb);
    }
}
