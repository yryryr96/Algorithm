import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int v = tangerine[i];
            int cnt = map.getOrDefault(v, 0);
            map.put(v, cnt+1);
        }
        
        for(int v : map.values()) {
            arr.add(v);
        }
        
        Collections.sort(arr, (a,b) -> b - a);
        
        int sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            answer++;
            if(sum >= k) break;
        }
        
        return answer;
    }
}