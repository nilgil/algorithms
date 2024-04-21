import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> sell = new HashMap<>();
        String[] sort = new String[1001];
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            int count = sell.getOrDefault(book, 0) + 1;
            sell.put(book, count);
            if (sort[count] == null || 0 < sort[count].compareTo(book)) {
                sort[count] = book;
            }
        }

        for (int i = 1000; i >= 0; i--) {
            if (sort[i] != null) {
                System.out.println(sort[i]);
                break;
            }
        }
    }
}
