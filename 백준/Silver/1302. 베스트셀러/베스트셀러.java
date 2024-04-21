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
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            sell.put(book, sell.getOrDefault(book, 0) + 1);
        }

        sell.entrySet().stream()
            .min((o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0 ?
                o1.getKey().compareTo(o2.getKey()) :
                o2.getValue().compareTo(o1.getValue()))
            .ifPresent(entry -> System.out.println(entry.getKey()));
    }
}
