import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isExist = new boolean[26];
        Character[] wheel = new Character[n];

        int idx = 0;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            idx = (idx + s) % n;
            if ((wheel[idx] != null && wheel[idx] != c)
                || (wheel[idx] == null && isExist[c - 'A'])) {
                System.out.println("!");
                return;
            }
            wheel[idx] = c;
            isExist[c - 'A'] = true;
        }

        for (int i = 0; i < n; i++) {
            int p = (idx - i + n) % n;
            Character c = wheel[p];
            sb.append(c == null ? '?' : c);
        }
        System.out.println(sb);
    }
}
