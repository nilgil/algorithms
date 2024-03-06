import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alps = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                alps[ch - 'A']++;
            } else {
                alps[ch - 'a']++;
            }
        }

        int result = 0;
        int max = Integer.MIN_VALUE;
        boolean duplicated = false;
        for (int i = 0; i < alps.length; i++) {
            int count = alps[i];
            if (max == count) {
                duplicated = true;
            } else if (max < count) {
                max = count;
                result = i;
                duplicated = false;
            }
        }

        if (duplicated) {
            System.out.println("?");
        } else {
            System.out.println((char) (result + 'A'));
        }
    }
}