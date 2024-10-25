import java.util.*;

class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        long answer = 0;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(deliveries[i] != 0 || pickups[i] != 0) idx = i;
        }
        
        while(idx >= 0) {
            if (deliveries[idx] == 0 && pickups[idx] == 0) {
                idx--;
                continue;
            }
            
            simulate(cap, idx, deliveries);
            simulate(cap, idx, pickups);
            
            answer += (idx + 1) * 2;
        }
        
        return answer;
    }
    
    static void simulate(int cap, int index, int[] arr) {
        
        while(index >= 0) {
            if(cap >= arr[index]) {
                cap -= arr[index];
                arr[index--] = 0;
            } else {
                arr[index] -= cap;
                break;
            }
        }
    }
}