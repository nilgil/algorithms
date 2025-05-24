class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        // key : 호수 번호 , value : 날짜
        Map<Integer, Integer> rainyDays = new HashMap<>();
        // 맑았던 날짜
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int rain = rains[i];
            if (rain == 0) {
                dryDays.add(i);
                rains[i] = 1;
            } else {
                if (rainyDays.containsKey(rain)) {
                    // 이전에 해당 호수에 비왔던 날 이후 가장 빠른 맑은날 찾기
                    Integer dryDay = dryDays.ceiling(rainyDays.get(rain));
                    if (dryDay == null) {
                        return new int[0];
                    }
                    rains[dryDay] = rain;
                    dryDays.remove(dryDay);
                }
                rains[i] = -1;
                rainyDays.put(rain, i);
            }
        }
        return rains;
    }
}