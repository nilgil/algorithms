class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i > 0; i--){
          if (i <= citations[citations.length - i]) {
            return i;
          }
        }
        return 0;
    }
}