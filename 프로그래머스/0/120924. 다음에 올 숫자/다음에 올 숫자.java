class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int value = common[0];
        int size = common.length;
        int last = common[size-1];
        
            
        if (common[1] - value == common[2] - common[1]) {
            answer = last + common[1] - value;
        }          
        else {
            answer = last*(common[size-1] / common[size-2]);
        }
        
        return answer;
    }
}