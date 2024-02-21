import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            List<Integer> nums = map.getOrDefault(x, new ArrayList<>());
            nums.add(y);
            map.put(x, nums);
        }
        int[] array = map.keySet().stream().mapToInt(value -> value).sorted().toArray();

        for (int x : array) {
            List<Integer> nums = map.get(x);
            nums.stream().sorted().forEach(y -> sb.append(x).append(' ').append(y).append('\n'));
        }
        System.out.println(sb);
    }
}