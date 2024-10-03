import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int n, s, count = 0;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        input();

        recursive(1, 0);
        // 모두 미포함 된 경우(가장 아래 가지로 쭉 뻗는 경우)
        // 끝까지 가서 합이 0이기에 S가 0이면 count 가 증가한다.
        // 이 경우를 대비해 S가 0인 경우를 체크해서 count 하나 내려줘야한다.
        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void recursive(int depth, int sum) {
        // 부분수열 완성된 상태
        if (depth == n + 1) {
            if (sum == s) {
                count++;
            }
        } else {
            // 포함
            recursive(depth + 1, sum + nums[depth]);
            // 미포함
            recursive(depth + 1, sum);
            // depth 번째 원소를 포함시킬지 결정하고 재귀호출
            // 두 갈래 길로 쭉 뻗어나감 (선택 여부를 갈래로 나눔)
        }
    }
}
