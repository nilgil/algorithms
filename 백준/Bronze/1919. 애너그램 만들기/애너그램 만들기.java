import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        int[] alps = new int[26];
        for (int i = 0; i < input1.length(); i++) {
            char ch = input1.charAt(i);
            alps[ch - 'a']++;
        }

        for (int i = 0; i < input2.length(); i++) {
            char ch = input2.charAt(i);
            alps[ch - 'a']--;
        }

        int count = 0;
        for (int alp : alps) {
            if (alp != 0) {
                count = count + (alp < 0 ? -alp : alp);
            }
        }

        System.out.println(count);
    }
}