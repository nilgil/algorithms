import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2 3 4 수열의 경우 답은
 * (0 * 2) + {(0 * 3) + (2 * 3)} + {(0 * 4) + (2 * 4) + (3 * 4)} 와 같다.
 * 중괄호 기준으로 보면 a * 3, b * 3과 같이 반복되어 더해지는데
 * 이걸 (a+b+c) * 3과 같이 묶을 수 있다.
 * 즉 현재 숫자 이전까지의 누적합 * 현재 숫자를 곱한값을 총합하면 된다.
 * */
public class Main {

	static int n;
	static long prefixSum = 0;
	static long multipleSum = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			multipleSum += prefixSum * now;
			prefixSum += now;
		}
		System.out.println(multipleSum);
	}
}
