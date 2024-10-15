import java.util.*;
class Solution {
    
    static int size;
    static int answer = Integer.MAX_VALUE;
    static int maxLimit = 0;
    
    public int solution(int[] picks, String[] minerals) {
        
        size = minerals.length;
        for(int i = 0; i < 3; i++) {
            maxLimit += picks[i];
        }
        
        dfs(0, 0, 0, picks, minerals);
        return answer;
    }
    
    static void dfs(int depth, int idx, int score, int[] picks, String[] minerals) {
        
        // System.out.println("depth = " + depth + " score = " + score);
        if(depth == maxLimit || idx == size) {
            answer = Math.min(score, answer);
            return;
        }
        
        
        for(int i = 0; i < 3; i++) {
            
            if (picks[i] > 0) {
                picks[i]--;
                int[] res = work(i, idx, minerals);
                int cnt = res[0];
                int n_idx = res[1];
                dfs(depth+1, n_idx + 1, score + cnt, picks, minerals);
                picks[i]++;
            }
        }
    }
    
    static int[] work(int type, int idx, String[] minerals) {
        
        int result = 0;
        int n_idx = idx;
        
        if (idx + 4 >= size) {
            for(int i = idx; i < size; i++) {
                int s = dig(type, minerals[i]);
                result += s;
                n_idx = i;
            }
        } 
        else {
            for(int i = idx; i <= idx+4; i++) {
                int s = dig(type, minerals[i]);
                result += s;
                n_idx = i;
            }
        }
        
        return new int[]{result, n_idx};
    }
    
    static int dig(int type, String stone) {
        if (type == 0) return 1;
        if (type == 1) {
            if (stone.equals("diamond")) return 5;
            else return 1;
        }
        
        if(type == 2) {
            if (stone.equals("diamond")) return 25;
            if (stone.equals("iron")) return 5;
            else return 1;
        }
        
        return 0;
    }
}