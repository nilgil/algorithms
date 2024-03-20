import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            Map<String, Integer> clothes = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String kind = br.readLine().split(" ")[1];
                clothes.put(kind, clothes.getOrDefault(kind, 1) + 1);
            }
            int count = clothes.values().stream()
                    .mapToInt(value -> value)
                    .reduce(1, (a, b) -> a * b);
            sb.append(count - 1).append('\n');
        }
        System.out.println(sb);
    }
}