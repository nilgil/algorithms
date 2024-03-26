import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static final int STUDENT_COUNT = 20;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int p = Integer.parseInt(br.readLine());
        while (p-- > 0) {
            int[] students = new int[STUDENT_COUNT];
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int i = 0; i < STUDENT_COUNT; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            int backCnt = 0;
            for (int i = 0; i < STUDENT_COUNT; i++) {
                for (int j = 0; j < i; j++) {
                    if (students[i] < students[j]) {
                        backCnt++;
                    }
                }
            }
            sb.append(t).append(' ').append(backCnt).append('\n');
        }
        System.out.println(sb);
    }
}
