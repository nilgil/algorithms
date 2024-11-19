class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int up = 0, down = 0, peak = 0, total = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) { // 올라가는 경우는 그대로 1씩 증가한 것들을 총합에 더함
                down = 0;
                up++;
                peak = up + 1;
                total += peak;
            } else if (ratings[i - 1] == ratings[i]) { // 초기화
                down = 0;
                up = 0;
                peak = 0;
                total++;
            } else { // 내려가는 경우는 1 밑으로는 내려갈 수 없으니 추후 보정해주는 개념
                down++;
                up = 0;
                total += down + 1 - (peak > down ? 1 : 0); // 더 내려갈 수 없으니 내려가기 전 피크를 하나 더 올리는 보정
            }
            // 실제로 더해지는 값들을 보면 2 1 2 3 4 1 2 3 과 같이 추후 보정된다.
        }
        return total;
    }
}