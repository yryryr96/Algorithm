import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        Deque<Integer> q = new LinkedList<>();
        for (int num : numbers) {
            q.add(num);
        }
        
        if (direction.equals("left")) {
            q.addLast(q.removeFirst());
        } else {
            q.addFirst(q.removeLast());
        }
        
        return q.stream().mapToInt(Integer::intValue).toArray();
    }
}