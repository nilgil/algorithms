import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public int[] solution(String[] names, int[] yearnings, String[][] photos) {
        return getPhotoScores(photos, createNameYearningMap(names, yearnings));
    }

    private static Map<String, Integer> createNameYearningMap(String[] names, int[] yearnings) {
        Map<String, Integer> nameYearningMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            nameYearningMap.put(names[i], yearnings[i]);
        }
        return nameYearningMap;
    }

    private static int[] getPhotoScores(String[][] photos, Map<String, Integer> nameYearningMap) {
        int[] scores = new int[photos.length];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = getPhotoScore(nameYearningMap, photos[i]);
        }
        return scores;
    }

    private static int getPhotoScore(Map<String, Integer> nameYearningMap, String[] photos) {
        int score = 0;
        for (String name : photos) {
            score += nameYearningMap.getOrDefault(name, 0);
        }
        return score;
    }
}