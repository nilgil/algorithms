import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        return getMaxReceiveGiftCount(createGiftBoard(gifts, createFriendsIndexMap(friends)));
    }

    private static Map<String, Integer> createFriendsIndexMap(String[] friends) {
        Map<String, Integer> friendsIndexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsIndexMap.put(friends[i], i);
        }
        return friendsIndexMap;
    }

    private static int[][] createGiftBoard(String[] gifts, Map<String, Integer> map) {
        int[][] giftBoard = createFriendsCountBoard(map.keySet().size());
        StringTokenizer st;
        for (String gift : gifts) {
            st = new StringTokenizer(gift);
            int senderIdx = map.get(st.nextToken());
            int receiverIdx = map.get(st.nextToken());
            giftBoard[senderIdx][receiverIdx]++;
            giftBoard[senderIdx][senderIdx]++;
            giftBoard[receiverIdx][receiverIdx]--;
        }
        return giftBoard;
    }

    private static int[][] createFriendsCountBoard(int friendsCount) {
        return new int[friendsCount][friendsCount];
    }

    private static int getMaxReceiveGiftCount(int[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (i == j) {
                    continue;
                }
                if (board[i][j] > board[j][i]) {
                    count++;
                } else if (board[i][j] == board[j][i] && board[i][i] > board[j][j]) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}