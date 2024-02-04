import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;

        // 소요 시간 우선순위 큐
        PriorityQueue<int[]> wq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        // 요청 시간 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.addAll(Arrays.asList(jobs));

        while(!pq.isEmpty() || !wq.isEmpty()) {

            // 현재 수행 가능한 모든 작업을 소요시간 우선순위 큐에 넣음
            while(!pq.isEmpty() && pq.peek()[0] <= time) {
                wq.offer(pq.poll());
            }

            if(wq.isEmpty()) {
                time = pq.peek()[0];
            } else {
                int[] p = wq.poll();
                answer += time - p[0] + p[1];
                time += p[1];
            }
        }

        answer /= jobs.length;
        return answer;
    }
}