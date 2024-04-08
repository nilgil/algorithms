import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int CAN_MAKE_THOUSAND_N = 45;
    static int[] triangles = new int[CAN_MAKE_THOUSAND_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < triangles.length; i++) {
            triangles[i] = i * (i + 1) / 2;
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(canSum(k) ? 1 : 0);
        }
    }

    private static boolean canSum(int k) {
        for (int i = 1; i < CAN_MAKE_THOUSAND_N; i++) {
            for (int j = 1; j < CAN_MAKE_THOUSAND_N; j++) {
                for (int l = 1; l < CAN_MAKE_THOUSAND_N; l++) {
                    if (triangles[i] + triangles[j] + triangles[l] == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
