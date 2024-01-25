class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] string_list = my_string.split("");
        String word = "";
        for (String s:string_list) {
            if (s.matches("[^a-zA-z]")) {
                word += s;
            } else {
                if (!word.isEmpty()) {
                    answer += Integer.parseInt(word);
                    word = "";    
                }
            }
        }
        
        if (!word.isEmpty()) {
            answer += Integer.parseInt(word);
        }
        return answer;
    }
}