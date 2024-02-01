import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        int pocketmon = nums.length/2;
        for (int num : nums) set.add(num);
        answer = pocketmon >= set.size() ? set.size() : pocketmon;
        return answer;
    }
}