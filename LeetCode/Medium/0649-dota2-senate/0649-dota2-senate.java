class Solution {
    public String predictPartyVictory(String senate) {

        Queue<String> queue = new LinkedList<>();

        int rBanCount = 0;
        int dBanCount = 0;

        char[] chars = senate.toCharArray();
        for (char c : chars) {
            queue.add(String.valueOf(c));
        }

        while (queue.size() != rBanCount && queue.size() != dBanCount) {
            String poll = queue.poll();

            if (poll.equals("R")) {
                if (dBanCount != 0) {
                    dBanCount--;
                } else {
                    rBanCount++;
                    queue.add("R");
                }
            } else if (poll.equals("D")) {
                if (rBanCount != 0) {
                    rBanCount--;
                } else {
                    dBanCount++;
                    queue.add("D");
                }
            }
        }

        return rBanCount > dBanCount ? "Radiant" : "Dire";
    }
}