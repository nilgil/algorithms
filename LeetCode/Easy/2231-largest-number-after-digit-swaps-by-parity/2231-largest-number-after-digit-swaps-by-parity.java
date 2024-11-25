class Solution {
    public int largestInteger(int num) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> odds = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> evens = new PriorityQueue<>(Comparator.reverseOrder());
        String strNum = String.valueOf(num);
        int n = strNum.length();
        boolean[] oddEven = new boolean[n];
        for (int i = 0; i < n; i++) {
            int currentNum = strNum.charAt(i) - '0';
            boolean isOdd = currentNum % 2 == 0;
            oddEven[i] = isOdd;
            if (isOdd) {
                odds.offer(currentNum);
            } else {
                evens.offer(currentNum);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (oddEven[i]) {
                result = result * 10 + odds.poll();
            } else {
                result = result * 10 + evens.poll();
            }
        }
        return result;
    }
}