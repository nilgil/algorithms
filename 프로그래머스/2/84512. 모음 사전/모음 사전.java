import java.util.Arrays;

class Solution {
    char[] chars = new char[5];
	char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U'};
    String word;
	int count = 0;
	boolean done = false;
    
    public int solution(String word) {
        this.word = word;
        Arrays.fill(chars, ' ');
		dfs(0);
		return count;
    }
    
    private void dfs(int depth) {
		if (done) {
			return;
		}
		if (String.valueOf(chars).trim().equals(word)) {
			done = true;
			return;
		}
		count++;
		if (5 == depth) {
			return;
		}
		for (char vowel : vowels) {
			chars[depth] = vowel;
			dfs(depth + 1);
			chars[depth] = ' ';
		}
	}
}