import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 모든 트럭 건너려면 최소 몇초?
        Queue<Integer> wq = new LinkedList<>();
        for(int t : truck_weights) {
            wq.add(t);
        }
        
        Queue<int[]> cq = new LinkedList<>();
        // cq.add(new int[]{1,wq.poll()});
        int time = 0;
        int curWeight = 0;
        while(!cq.isEmpty() || !wq.isEmpty()) {
                       
            if(!cq.isEmpty() && cq.peek()[0] == (time - bridge_length)) {
                int[] c = cq.poll();
                curWeight -= c[1];
                // System.out.println("time = " + time + " c = " + c[1]);
            }
            
            if(!wq.isEmpty() && (curWeight + wq.peek() <= weight)) {
                int w = wq.poll();
                cq.add(new int[]{time, w});
                curWeight += w;
                // System.out.println("time = " + time + " w = " + w);
            }
            
            time++;
        }
        
        return time;
    }
}