import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int p = 0;
        while (!nums.isEmpty()) {
            p += k - 1;
            p %= nums.size();
            sb.append(nums.remove(p)).append(", ");
        }
        sb.replace(sb.lastIndexOf(","), sb.length(), ">");
        System.out.println(sb);
    }
}