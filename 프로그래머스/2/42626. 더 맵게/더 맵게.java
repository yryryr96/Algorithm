import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }
        int cnt = 0;
        while(!pq.isEmpty()) {
            
            if (pq.peek() >= K) return cnt;
            
            if (pq.size() >= 2) {
                int one = pq.poll();
                int two = pq.poll();
                int res = one + 2*two;
                pq.add(res);
                cnt++;
            } else {
                break;
            }
        }

        return -1;
    }
}