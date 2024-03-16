import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] names = new String[n + 1];
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            names[i] = name;
            idxMap.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            if (Character.isAlphabetic(q.charAt(0))) {
                sb.append(idxMap.get(q)).append('\n');
            } else {
                int num = Integer.parseInt(q);
                sb.append(names[num]).append('\n');
            }
        }

        System.out.println(sb);
    }
}