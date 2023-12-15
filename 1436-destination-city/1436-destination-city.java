class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            String departure = path.get(0);
            String destination = path.get(1);
            map.put(departure, map.getOrDefault(departure, 0) + 1);
            map.put(destination, map.getOrDefault(destination, 0) - 1);
        }
        for (String city : map.keySet()) {
            if (map.get(city) < 0) {
                return city;
            }
        }
        return null;
    }
}