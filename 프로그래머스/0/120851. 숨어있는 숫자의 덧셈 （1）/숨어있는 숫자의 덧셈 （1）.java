class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String numString = my_string.replaceAll("[^0-9]","");
        String[] numString_list = numString.split("");
        
        for (String s : numString_list) {
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}