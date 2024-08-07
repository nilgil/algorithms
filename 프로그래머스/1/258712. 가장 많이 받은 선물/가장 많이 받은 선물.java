import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    
    public static int solution(String[] friends, String[] gifts) {
        return getMaxReceiveCount(createGiftBoard(gifts, createFriendsIndexMap(friends)));
    }

    private static Map<String, Integer> createFriendsIndexMap(String[] friends) {
        Map<String, Integer> friendsIndexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsIndexMap.put(friends[i], i);
        }
        return friendsIndexMap;
    }

    private static int[][] createGiftBoard(String[] gifts, Map<String, Integer> friendsIndexMap) {
        int friendsCount = friendsIndexMap.keySet().size();
        int[][] giftBoard = new int[friendsCount][friendsCount];
        StringTokenizer st;
        for (String gift : gifts) {
            st = new StringTokenizer(gift);
            int senderIdx = friendsIndexMap.get(st.nextToken());
            int receiverIdx = friendsIndexMap.get(st.nextToken());
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

    private static int getReceiveCount(int[][] giftBoard, int currentIndex) {
        int count = 0;
        for (int targetIndex = 0; targetIndex < giftBoard.length; targetIndex++) {
            if (currentIndex == targetIndex) {
                continue;
            }
            if (isCurrentWin(giftBoard, currentIndex, targetIndex)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isCurrentWin(int[][] giftBoard, int currentIndex, int targetIndex) {
        if (getBeforeSendCount(giftBoard, currentIndex, targetIndex) >
            getBeforeReceiveCount(giftBoard, currentIndex, targetIndex)) {
            return true;
        }
        if (getBeforeSendCount(giftBoard, currentIndex, targetIndex) <
            getBeforeReceiveCount(giftBoard, currentIndex, targetIndex)) {
            return false;
        }
        return getBeforeGiftScore(giftBoard, currentIndex) >
            getBeforeGiftScore(giftBoard, targetIndex);
    }

    private static int getBeforeSendCount(int[][] giftBoard, int currentIndex, int targetIndex) {
        return giftBoard[currentIndex][targetIndex];
    }

    private static int getBeforeReceiveCount(int[][] giftBoard, int currentIndex, int targetIndex) {
        return giftBoard[targetIndex][currentIndex];
    }

    private static int getBeforeGiftScore(int[][] giftBoard, int friendIndex) {
        return giftBoard[friendIndex][friendIndex];
    }
}