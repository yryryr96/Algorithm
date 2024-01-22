class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int even = 0;
        int odd = 0;
        
        for (int number : num_list) {
            if (number%2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        
        answer[0] = even;
        answer[1] = odd;
        return answer;
    }
}