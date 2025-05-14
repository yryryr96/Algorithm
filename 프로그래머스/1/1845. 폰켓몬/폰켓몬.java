import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int length = nums.length;
        if (set.size() >= length / 2) {
            answer = length / 2;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}