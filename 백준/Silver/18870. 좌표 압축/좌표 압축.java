import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            set.add(nums[i]);
        }

        Map<Integer, Integer> ranks = new HashMap<>();
        int index = 0;
        for (int x : set) {
            ranks.put(x, index++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ranks.get(nums[i])).append(' ');
        }
        System.out.println(sb);
    }
}
