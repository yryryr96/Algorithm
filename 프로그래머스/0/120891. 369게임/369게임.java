class Solution {
    public int solution(int order) {
        int answer = 0;
        String orderToString = String.valueOf(order);
        for (int i=0; i<orderToString.length(); i++) {
            char c = orderToString.charAt(i);
            if (c=='3' || c=='6' || c=='9') {
                answer ++;
            }
        }
        return answer;
    }
}