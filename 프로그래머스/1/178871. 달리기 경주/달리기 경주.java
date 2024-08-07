import java.util.HashMap;
import java.util.Map;

class Solution {

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRankMap = createPlayerRankMap(players);
        for (String calledPlayer : callings) {
            outstrip(players, calledPlayer, playerRankMap);
        }
        return players;
    }

    private static Map<String, Integer> createPlayerRankMap(String[] players) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        return map;
    }

    private void outstrip(String[] players, String calledPlayer,
        Map<String, Integer> playerRankMap) {
        int calledPlayerRank = playerRankMap.get(calledPlayer);
        String frontPlayer = players[calledPlayerRank - 1];
        players[calledPlayerRank - 1] = calledPlayer;
        players[calledPlayerRank] = frontPlayer;
        playerRankMap.put(calledPlayer, calledPlayerRank - 1);
        playerRankMap.put(frontPlayer, calledPlayerRank);
    }
}