import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (a > m) {
			System.out.println(0);
			return;
		}
		int gage = 0;
		int work = 0;
		int hours = 24;
		while (hours-- > 0) {
			if (m < gage || m < gage + a) {
				gage -= c;
				if (gage < 0) {
					gage = 0;
				}
			} else {
				gage += a;
				work += b;
			}
		}
		System.out.println(work);
	}
}
