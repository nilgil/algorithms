class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 해시맵 생성
        Map<String, List<String>> map = new HashMap<>();

        // HashMap에 정렬한 단어를 키로 등록
        for (String word : strs) {
            String sorted = word.codePoints().sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            List<String> existOrNew = map.getOrDefault(sorted, new ArrayList<>());
            existOrNew.add(word);
            map.put(sorted, existOrNew);
        }

        // 조회
        return new ArrayList<>(map.values());
    }
}