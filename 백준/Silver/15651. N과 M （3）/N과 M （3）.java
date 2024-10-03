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
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
    }

    static int n, m;
    static int[] selected;

    // 3 3 의 경우
    // 1 - 1 - 1 까지 타고 들어간 후 프린트 마킹(sb)하고 빠져나오면 1 - 1 - 2로 넘어감
    // 첫 시도가 1 - 1 - 1로 순회문을 전혀 돌지 않고 끝까지 타고 들어가는게 중요 포인트
    // 첫번째 성공 후에 !한 뎁스만! 나와서 순회로 돌아가는 것도 포인트
    private static void recursive(int depth) {
        // depth 가 끝에 도달한 경우 프린트 대상에 추가한 후 빠져나옴
        if (depth == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        // 아직 원하는 depth 에 도달하지 못한 경우
        else {
            // 중복 상관없으니 모든 숫자 순회
            for (int i = 1; i <= n; i++) {
                selected[depth] = i;
                recursive(depth + 1);
                selected[depth] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        recursive(1);

        System.out.println(sb);
    }
}
