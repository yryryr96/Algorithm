import java.util.*;
class Solution {
    
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b) -> b-a);
    static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        
        for(String operation : operations) {
        
            String[] command = operation.split(" ");
            String c = command[0];
            int num = Integer.parseInt(command[1]);
            
            if (c.equals("I")) insert(num);
            else delete(num);
        }
                
        return (maxQ.isEmpty() || minQ.isEmpty()) ? new int[]{0,0} : new int[]{maxQ.poll(), minQ.poll()};
    }
    
    static void insert(int num) {
        minQ.add(num);
        maxQ.add(num);
    }
    
    static void delete(int flag) {
        
        if (maxQ.isEmpty() || minQ.isEmpty()) return;
        
        if (flag == 1) {
            int v = maxQ.poll();
            minQ.remove(v);
        } 
        else {
            int v = minQ.poll();
            maxQ.remove(v);
        }
    }
}