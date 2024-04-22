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
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            nums[i] = x;
        }

        int[] sorted = Arrays.stream(nums)
            .distinct()
            .sorted()
            .toArray();

        Map<Integer, Integer> ranks = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            ranks.put(sorted[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ranks.get(nums[i])).append(' ');
        }
        System.out.println(sb);
    }
}
