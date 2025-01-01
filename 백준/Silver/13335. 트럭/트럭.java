import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] weights = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 1; i <= w; i++) {
			bridge.offer(0);
		}
		
		int time = 0;
		int idx = 1;
		int currentWeight = 0;
		while (idx <= n) {
			Integer outTruckWeight = bridge.poll();
			currentWeight -= outTruckWeight;

			if (currentWeight + weights[idx] <= l) {
				bridge.offer(weights[idx]);
				currentWeight += weights[idx];
				idx++;
			} else {
				bridge.offer(0);
			}
			time++;
		}
		System.out.println(time + w);
	}
}
