import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> sell = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            sell.put(book, sell.getOrDefault(book, 0) + 1);
        }

        String maxTitle = "";
        int maxCount = 0;
        for (Entry<String, Integer> entry : sell.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            if (maxCount < count || maxCount == count && name.compareTo(maxTitle) < 0) {
                maxTitle = name;
                maxCount = count;
            }
        }
        System.out.println(maxTitle);
    }
}
