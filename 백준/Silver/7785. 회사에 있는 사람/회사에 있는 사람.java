import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> company = new HashSet<>();
        StringTokenizer st;
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

        StringBuilder sb = new StringBuilder();
        company.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(name -> sb.append(name).append('\n'));

        System.out.println(sb);
    }
}
