import java.util.*;
class Solution {
    public int[] solution(int n) {
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i=0; i<=n; i++) {
            
            if (i%2 == 1) {
                arr.add(i);
            }
        }
        
        return arr.stream().mapToInt(x->x).toArray();
    }
}