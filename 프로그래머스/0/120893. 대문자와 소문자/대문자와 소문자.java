class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        char[] char_list = my_string.toCharArray();
        for (char c : char_list) {
            if (Character.isUpperCase(c)) {
                answer += Character.toLowerCase(c);
            } else {
                answer += Character.toUpperCase(c);
            }
        }
        return answer;
    }
}