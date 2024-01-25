class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String newString = my_string.replaceAll("[a-zA-z]"," ");
        String[] string_list = newString.split(" ");
        for (String s:string_list) {
            if (!s.equals("")) answer += Integer.parseInt(s);
        }
        
        return answer;
    }
}