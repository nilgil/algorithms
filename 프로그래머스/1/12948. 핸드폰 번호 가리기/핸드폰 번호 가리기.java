class Solution {
    public String solution(String phone_number) {
        int bound = phone_number.length() - 4;
        return "*".repeat(bound) + phone_number.substring(bound);
    }
}