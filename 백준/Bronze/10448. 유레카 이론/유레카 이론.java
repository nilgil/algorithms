import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isEurekaNumber = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        preProcess();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(isEurekaNumber[k] ? 1 : 0);
        }
    }

    private static void preProcess() {
        int triangleNumberCount = 0;
        int[] triangleNumbers = new int[50];
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (1000 <= triangleNumber) {
                break;
            }
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }

        boolean[] isSumOfTriangleNumber = new boolean[1001];
        for (int i = 0; i < triangleNumberCount; i++) {
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) {
                    isSumOfTriangleNumber[sum] = true;
                }
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (!isSumOfTriangleNumber[i]) {
                continue;
            }
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = i + triangleNumbers[j];
                if (sum <= 1000) {
                    isEurekaNumber[sum] = true;
                }
            }
        }
    }
}
