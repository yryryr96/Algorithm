class Solution {
    public int solution(int order) {
        int answer = 0;
        String[] orderToString = String.valueOf(order).split("");
        for (String num : orderToString) {
            if (num.equals("3") || num.equals("6") || num.equals("9")) {
                answer += 1;
            }
        }
        
        return answer;
    }
}