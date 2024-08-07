import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        return getMaxReceiveCount(createGiftBoard(gifts, createFriendsIndexMap(friends)));
    }

    private static Map<String, Integer> createFriendsIndexMap(String[] friends) {
        Map<String, Integer> friendsIndexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsIndexMap.put(friends[i], i);
        }
        return friendsIndexMap;
    }

    private static int[][] createGiftBoard(String[] gifts, Map<String, Integer> map) {
        int friendsCount = map.keySet().size();
        int[][] giftBoard = new int[friendsCount][friendsCount];
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

    private static int getMaxReceiveCount(int[][] giftBoard) {
        int maxReceiveCount = 0;
        for (int senderIndex = 0; senderIndex < giftBoard.length; senderIndex++) {
            maxReceiveCount = Math.max(maxReceiveCount, getReceiveCount(giftBoard, senderIndex));
        }
        return maxReceiveCount;
    }

    private static int getReceiveCount(int[][] board, int currentIndex) {
        int count = 0;
        for (int targetIndex = 0; targetIndex < board.length; targetIndex++) {
            if (currentIndex == targetIndex) {
                continue;
            }
            if (isCurrentWin(board, currentIndex, targetIndex)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isCurrentWin(int[][] board, int currentIndex, int targetIndex) {
        if (getBeforeSendCount(board, currentIndex, targetIndex) >
            getBeforeReceiveCount(board, currentIndex, targetIndex)) {
            return true;
        }
        if (getBeforeSendCount(board, currentIndex, targetIndex) <
            getBeforeReceiveCount(board, currentIndex, targetIndex)) {
            return false;
        }
        return getBeforeGiftScore(board, currentIndex) > getBeforeGiftScore(board, targetIndex);
    }

    private static int getBeforeSendCount(int[][] board, int currentIndex, int targetIndex) {
        return board[currentIndex][targetIndex];
    }

    private static int getBeforeReceiveCount(int[][] board, int currentIndex, int targetIndex) {
        return board[targetIndex][currentIndex];
    }

    private static int getBeforeGiftScore(int[][] board, int friendIndex) {
        return board[friendIndex][friendIndex];
    }
}