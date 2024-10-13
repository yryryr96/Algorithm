import java.util.*;
class Solution {
    
    static int[][] distance;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        distance = new int[n+1][n+1];
        initMinimumDistance(n, fares);
        getAnswer(n,s,a,b);
        return answer;
    }
    
    static void getAnswer(int n, int s, int a, int b) {
        
        int togetherDist, toA, toB;
        
        for(int i = 1; i <= n; i++) {
                       
            togetherDist = distance[s][i];           
            toA = distance[i][a];           
            toB = distance[i][b];
            
            answer = Math.min(togetherDist + toA + toB, answer);
        }
    }
    
    static void initMinimumDistance(int n, int[][] fares) {
        
        int INF = 100001*200;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j) {
                    distance[i][j] = INF;
                }
            }
        }
        
        // 최초 거리 갱신
        for(int[] fare : fares) {
            int a = fare[0];
            int b = fare[1];
            int f = fare[2];
            
            distance[a][b] = f;
            distance[b][a] = f;
        }
        
        // 플로이드 워셜 모든 지점 최소 거리 갱신 n <= 200 이므로 가능
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i==j) continue;
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
}