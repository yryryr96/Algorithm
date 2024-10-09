class Solution {
    
    static long timeLimit;
    static int l;
    static int MAX_LEVEL = 100000;
    static int MIN_LEVEL = 1;
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        int answer = 0;
        timeLimit = limit;
        l = diffs.length;
        
        answer = binarySearch(diffs, times);
        
        return answer;
    }
    
    static int binarySearch(int[] diffs, int[] times) {
        
        int curLevel = (MAX_LEVEL + MIN_LEVEL) / 2;
        
        while(MIN_LEVEL < MAX_LEVEL) {
            
            if (canSolve(diffs, times, curLevel)) {
                MAX_LEVEL = curLevel;
                curLevel = (MAX_LEVEL + MIN_LEVEL) / 2;
            } else {
                MIN_LEVEL = curLevel + 1;
                curLevel = (MAX_LEVEL + MIN_LEVEL) / 2;
            }
        }
        
        return curLevel;
    }
    
    static boolean canSolve(int[] diffs, int[] times, int curLevel) {
        
        long time = 0;
        
        for (int i = 0; i < l; i++) {
            
            // diff <= level 이면 time_cur만큼 시간 사용
            if (diffs[i] <= curLevel) {
                time += times[i];
            }
            
            // diff > level 이면 diff-level번 틀리고, time_prev만큼 시간 사용해야함
            
            else {
                time += ((times[i] + times[i-1]) * (diffs[i] - curLevel) + times[i]);
            }
            
            if (time > timeLimit) return false;
        }
        
        return true;
    }
}