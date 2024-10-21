import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int totalCount = 0;

		LinkedHashMap<String, Integer> works = new LinkedHashMap<>() {{
			put("Re", 0);
			put("Pt", 0);
			put("Cc", 0);
			put("Ea", 0);
			put("Tb", 0);
			put("Cm", 0);
			put("Ex", 0);
		}};

		String line;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				String work = st.nextToken();
				if (works.containsKey(work)) {
					works.put(work, works.get(work) + 1);
				}
				totalCount++;
			}
		}

		for (String key : works.keySet()) {
			Integer value = works.get(key);
			String ratio = String.format("%s %d %.2f", key, value, ((double)value / totalCount));
			sb.append(ratio).append('\n');
		}
		sb.append(String.format("Total %d 1.00", totalCount));
		System.out.println(sb);
	}
}
