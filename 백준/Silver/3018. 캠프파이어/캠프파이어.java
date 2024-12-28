import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static final int SY_NUMBER = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		List<Set<Integer>> songKnowledge = new ArrayList<>();

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			Set<Integer> participants = new HashSet<>();

			for (int j = 1; j <= K; j++) {
				participants.add(Integer.parseInt(st.nextToken()));
			}

			if (participants.contains(SY_NUMBER)) {
				songKnowledge.add(participants);
			} else {
				for (Integer participant : participants) {
					for (Set<Integer> value : songKnowledge) {
						if (value.contains(participant)) {
							value.addAll(participants);
						}
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (Set<Integer> participants : songKnowledge) {
				if (participants.contains(i)) {
					count++;
				}
			}
			if (count == songKnowledge.size()) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
}
