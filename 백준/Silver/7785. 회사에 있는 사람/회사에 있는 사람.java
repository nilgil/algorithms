import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<String> company = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();
            if (action.equals("enter")) {
                company.add(name);
            } else {
                company.remove(name);
            }
        }

        String[] ordered = company.toArray(new String[0]);

        StringBuilder sb = new StringBuilder();
        for (int i = ordered.length - 1; i >= 0; i--) {
            sb.append(ordered[i]).append('\n');
        }

        System.out.println(sb);
    }
}
