import java.util.*;

class Solution {
    
    public int solution(int alp, int cop, int[][] problems) {
        
        int answer = 0;
        int maxAlp = alp, maxCop = cop;
        
        for(int i = 0; i < problems.length; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        
        // 알고력, 코딩력
        // 알고력, 코딩력 1올리는데 1시간 , 풀 수 있는 문제 하나 풀어서
        // problem : [알고력, 코딩력, 알고력증가, 코딩력증가, 시간]
        
        int[][] time = new int[maxAlp+5][maxCop+5];
        for(int i = 0; i < time.length; i++) {
            Arrays.fill(time[i], 1000);
        }
        
        time[alp][cop] = 0;
        for(int i = alp; i <= maxAlp; i++) {
            for(int j = cop; j <= maxCop; j++) {
                
                for(int k = 0; k < problems.length; k++) {
                    
                    time[i+1][j] = Math.min(time[i][j] + 1, time[i+1][j]);
                    time[i][j+1] = Math.min(time[i][j] + 1, time[i][j+1]);
                    
                    if(i < problems[k][0] || j < problems[k][1]) continue;
                    
                    int nAlp = Math.min(i + problems[k][2], maxAlp);
                    int nCop = Math.min(j + problems[k][3], maxCop);
                    int t = problems[k][4];
                    
                    if(time[nAlp][nCop] > time[i][j] + t) {
                        // System.out.println(time[i][j] + " t : " + t);
                        time[nAlp][nCop] = time[i][j] + t;
                    }
                }
            }
        }
        
        answer = time[maxAlp][maxCop];
        return answer;
    }
                
}