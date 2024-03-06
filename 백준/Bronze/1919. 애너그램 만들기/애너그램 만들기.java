import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        char[] chars1 = input1.toCharArray();
        char[] chars2 = input2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        int count = 0;

        int i = 0;
        int j = 0;
        while (i != chars1.length && j != chars2.length) {
            char ch1 = chars1[i];
            char ch2 = chars2[j];

            if (ch1 == ch2) {
                i++;
                j++;
                continue;
            }

            if (ch1 < ch2) {
                i++;
            } else {
                j++;
            }
            count++;
        }

        if (i == chars1.length) {
            count += chars2.length - j;
        } else {
            count += chars1.length - i;
        }

        System.out.println(count);
    }
}