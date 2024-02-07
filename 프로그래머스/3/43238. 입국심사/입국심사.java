import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long maxTime = (long) n * (long) times[times.length-1];
        long minTime = (long) 1;
        long answer = maxTime;

        while (minTime <= maxTime) {

            long mid = (maxTime + minTime) / 2;
            long temp = 0;

            for (int i = 0; i < times.length; i++) {
                temp += mid / times[i];
                if (temp >= n) break;
            }

            if (temp < n) {
                minTime = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                maxTime = mid - 1;
            }
        }

        return answer;
    }
}