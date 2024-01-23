class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        String[] string_list = my_string.split("");
        String tmp = string_list[num1];
        string_list[num1] = string_list[num2];
        string_list[num2] = tmp;
        
        answer = String.join("", string_list);
        return answer;
    }
}