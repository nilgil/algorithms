import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] nums;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        check = new boolean[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        perm(0, 0);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    static void perm(int depth, int idx) {
        // base case
        if (depth == m) {                           // 원하는 원소 개수 순열 조합시
            for (int i = 0; i < m; i++) {           // 결과본 출력
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursive case
        for (int i = idx; i < n; i++) {
            if (!check[i]) {                // 아직 안들렀다면
                check[i] = true;            // 이제 들렀다는 마킹
                output[depth] = nums[i];    // 지금 만들고있는 순열 결과본에 추가
                perm(depth + 1, i + 1);     // 다음 뎁스 진행 -> 다음 뎁스에서는 현재 인덱스 다음부터 순회
                check[i] = false;           // 다른 조합을 위해 check 해제
            }
        }
    }
}
