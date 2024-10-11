import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        
        // 결국 걸리는 시간의 최소값 구하기
        // 각 상담원이 총 소요 시간동안 심사하는 인원의 총 합이 n명이면 됨
        
        Arrays.sort(times);
        
        Long maxTime = (long) n * times[times.length-1];
        Long minTime = (long) times[0];
        Long answer = maxTime;
        
        while (minTime <= maxTime) {
            
            Long mid = (maxTime + minTime) / 2;
            
            long cnt = 0L;
            
            for(int i = 0; i < times.length; i++) {
                cnt += (mid / times[i]);
                if (cnt > n) break;
            }
            // System.out.println("cnt = " + cnt + " time = " + mid);
            // 심사한 사람이 총 인원을 넘으면 시간을 더 적게잡아야함
            if(cnt >= n) {
                maxTime = mid - 1;
                // 총 인원일때도 -1씩 계속 해서 탐색하므로 최소값을 저장해줘야함 -> 결국 n일때까지 탐색
                answer = Math.min(answer, mid);
            } else {
            // 심사한 사람이 총 인원보다 적다면 시간 범위를 더 늘려야함
            
                minTime = mid + 1;
            }
        }
        return answer;
    }
}