import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int ALPHABET_COUNT = 26;
    private static final int DIVIDE_COUNT = 14;
    private static final int MIN_VOTES_RATE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] finalStaff = new boolean[26];
        int[][] map = new int[ALPHABET_COUNT][DIVIDE_COUNT];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char name = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt * 100 / x < MIN_VOTES_RATE) {
                continue;
            }
            finalStaff[name - 'A'] = true;
            for (int j = 1; j <= DIVIDE_COUNT; j++) {
                map[name - 'A'][j - 1] = cnt / j;
            }
        }

        int[] indexes = new int[ALPHABET_COUNT];
        for (int i = 0; i < DIVIDE_COUNT; i++) {
            int max = 0;
            int winner = -1;
            for (int j = 0; j < ALPHABET_COUNT; j++) {
                int part = map[j][indexes[j]];
                if (max < part) {
                    max = part;
                    winner = j;
                }
            }
            indexes[winner]++;
        }

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (!finalStaff[i]) {
                continue;
            }
            String line = String.format("%s %d\n", (char) (i + 'A'), indexes[i]);
            sb.append(line);
        }
        System.out.println(sb);
    }
}
