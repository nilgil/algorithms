import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        IdxNumber[] nums = new IdxNumber[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new IdxNumber(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nums, Comparator.comparing(o -> o.x));
        int head = 0;
        nums[0].sort = head;
        for (int i = 1; i < n; i++) {
            IdxNumber previous = nums[i - 1];
            IdxNumber current = nums[i];
            if (!previous.x.equals(current.x)) {
                head++;
            }
            current.sort = head;
        }

        Arrays.sort(nums, Comparator.comparing(o -> o.index));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i].sort).append('\n');
        }

        System.out.println(sb);
    }

    static class IdxNumber {

        private final Integer index;
        private final Integer x;
        private Integer sort;

        public IdxNumber(int index, int x) {
            this.index = index;
            this.x = x;
        }
    }
}
