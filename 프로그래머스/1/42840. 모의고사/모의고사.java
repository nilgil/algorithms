import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[patterns.length];
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == patterns[0][i % 5]) {
                scores[0]++;
            }
            if (answer == patterns[1][i % 8]) {
                scores[1]++;
            }
            if (answer == patterns[2][i % 10]) {
                scores[2]++;
            }
        }
        int max = Arrays.stream(scores).max().getAsInt();
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                winners.add(i + 1);
            }
        }
        int[] result = new int[winners.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = winners.get(i);
        }
        return result;
    }
}