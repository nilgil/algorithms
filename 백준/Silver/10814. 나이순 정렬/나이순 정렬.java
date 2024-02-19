import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] users = new String[201];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users[age] = users[age] == null ? name : users[age] + " " + name;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < users.length; i++) {
            String user = users[i];
            if (user == null) {
                continue;
            }
            StringTokenizer st = new StringTokenizer(user);
            while (st.hasMoreTokens()) {
                bw.write(i + " " + st.nextToken());
                bw.newLine();
            }
        }
        bw.flush();
    }
}