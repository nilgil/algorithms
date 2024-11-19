class Solution {

    private final Map<Character, Integer> map;

    public Solution() {
        map = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
    }

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Integer current = map.get(s.charAt(i));
            Integer next = map.get(s.charAt(i + 1));
            if (current < next) {
                res -= current;
            } else {
                res += current;
            }
        }
        return res += map.get(s.charAt(s.length() - 1));
    }
}