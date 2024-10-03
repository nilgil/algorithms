import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited;
        String line;
        int result = 0;
        while (n-- > 0) {
            visited = new boolean['z' - 'a' + 1];
            line = br.readLine();

            char before = line.charAt(0);
            visited[before - 'a'] = true;

            int cnt = 1;
            for (int i = 1; i < line.length(); i++) {
                char now = line.charAt(i);
                if (now == before) {
                    cnt++;
                    continue;
                }
                if (visited[now - 'a']) {
                    break;
                }
                visited[now - 'a'] = true;
                before = now;
                cnt++;
            }
            if (cnt == line.length()) {
                result++;
            }
        }
        System.out.println(result);
    }
}
