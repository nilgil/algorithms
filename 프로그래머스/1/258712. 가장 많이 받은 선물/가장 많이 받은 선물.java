import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
		Map<String, Integer> friendIdxMap = new HashMap<>();
		for (int i = 0; i < friends.length; i++) {
			friendIdxMap.put(friends[i], i);
		}

		int[][] matrix = new int[friends.length][friends.length];
		StringTokenizer st;
		for (String gift : gifts) {
			st = new StringTokenizer(gift);
			int senderIdx = friendIdxMap.get(st.nextToken());
			int receiverIdx = friendIdxMap.get(st.nextToken());
			matrix[senderIdx][receiverIdx]++;

			matrix[senderIdx][senderIdx]++;
			matrix[receiverIdx][receiverIdx]--;
		}

		int maxReceiveCount = 0;
		for (int i = 0; i < friends.length; i++) {
			int totalReceiveCount = 0;
			for (int j = 0; j < friends.length; j++) {
				if (i == j) {
					continue;
				}
				int currentIdx = friendIdxMap.get(friends[i]);
				int targetIdx = friendIdxMap.get(friends[j]);
				int sendCount = matrix[currentIdx][targetIdx];
				int receiveCount = matrix[targetIdx][currentIdx];
				if (sendCount < receiveCount) {
					continue;
				}
				int currentScore = matrix[currentIdx][currentIdx];
				int targetScore = matrix[targetIdx][targetIdx];
				if (receiveCount < sendCount || targetScore < currentScore) {
					totalReceiveCount++;
				}
			}
			maxReceiveCount = Math.max(maxReceiveCount, totalReceiveCount);
		}
		return maxReceiveCount;
	}
}