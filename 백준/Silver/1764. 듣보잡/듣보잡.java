import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }

        int head = 0;
        String[] anonymous = new String[Math.max(n, m)];
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (map.get(name) != null) {
                anonymous[head++] = name;
            }
        }
        Arrays.sort(anonymous, 0, head);

        for (int i = 0; i < head; i++) {
            sb.append(anonymous[i]).append('\n');
        }

        System.out.println(head);
        System.out.println(sb);
    }
}