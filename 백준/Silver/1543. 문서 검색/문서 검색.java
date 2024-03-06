import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();

        int result = 0;
        int startIdx = 0;
        while (true) {
            int idx = doc.indexOf(word, startIdx);
            if (idx < 0) {
                break;
            }
            result++;
            startIdx = idx + word.length();
        }
        System.out.println(result);
    }
}