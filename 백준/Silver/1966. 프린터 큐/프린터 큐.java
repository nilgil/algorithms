import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] docs = new int[n];
            int[] sorted = new int[n];
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                docs[j] = priority;
                sorted[j] = priority;
            }

            int mostImportant = sorted.length - 1;
            Arrays.sort(sorted);

            int count = 0;
            int head = 0;
            while (docs[m] != -1) {
                if (docs[head] >= sorted[mostImportant]) {
                    docs[head] = -1;
                    mostImportant--;
                    count++;
                }
                head++;
                head %= docs.length;
            }
            System.out.println(count);
        }
    }
}