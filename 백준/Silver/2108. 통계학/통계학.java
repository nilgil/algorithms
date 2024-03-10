import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] nums = new int[n];
        int[] counts = new int[8001];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            counts[nums[i] + 4000]++;
        }

        Arrays.sort(nums);

        System.out.println(average(sum, n));

        System.out.println(middle(nums));

        System.out.println(many(counts));

        System.out.println(range(nums));

    }

    private static long average(int sum, double n) {
        return Math.round(sum / n);
    }

    private static int middle(int[] nums) {
        return nums[nums.length / 2];
    }

    private static int many(int[] counts) {
        List<Integer> manies = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            if (max == counts[i]) {
                manies.add(i);
            } else if (max < counts[i]) {
                manies = new ArrayList<>();
                manies.add(i);
                max = counts[i];
            }
        }

        Collections.sort(manies);

        if (manies.size() > 1) {
            return manies.get(1) - 4000;
        }
        return manies.get(0) - 4000;
    }

    private static int range(int[] nums) {
        return nums[nums.length - 1] - nums[0];
    }
}