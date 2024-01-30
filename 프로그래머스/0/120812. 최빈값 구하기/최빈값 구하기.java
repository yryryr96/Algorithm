import java.util.*;
class Solution {
    public int solution(int[] array) {

        int maxCount = 0;
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : array) {

            int count = map.getOrDefault(number,0) + 1;

            if (count > maxCount) {
                answer = number;
                maxCount = count;
            } else if(count == maxCount) {
                answer = -1;
            }

            map.put(number, count);
        }
        return answer;
    }
}