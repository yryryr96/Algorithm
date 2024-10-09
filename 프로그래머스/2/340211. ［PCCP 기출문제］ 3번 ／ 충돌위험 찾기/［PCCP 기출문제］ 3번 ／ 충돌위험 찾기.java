import java.util.*;

class Solution {

    static Queue<int[]>[] qList;
    static int robotCnt;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;    
        
        robotCnt = routes.length;
        qList = new LinkedList[routes.length];
        for (int i = 0; i < robotCnt; i++) {
            qList[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < robotCnt; i++) {
            move(i, routes[i], points);
        }
        
        answer = getAnswer();
        return answer;
    }
    
    static int getAnswer() {
        
        int ans = 0;
        int count = 0;
        
        
        while (count != robotCnt) {
            
            int[][] history = new int[100][100];
            count = 0;
            
            for (int k = 0; k < robotCnt; k++) {            
                
                if(qList[k].isEmpty()) {
                    count++;
                    continue;
                }
                
                int[] p = qList[k].poll();
                history[p[0]][p[1]]++;   
            }
            
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (history[i][j] > 1) {
                        // System.out.println("i = " + i + " j = " + j);
                        ans++;
                    }
                }
            } 
        }

        return ans;
    }
    
    static void move(int num, int[] route, int[][] points) {
        
        int aim = 0;
        int ci = points[route[aim] - 1][0] - 1;
        int cj = points[route[aim] - 1][1] - 1;
        qList[num].add(new int[]{ci,cj});        
        
        aim++;
        
        while (aim < route.length) {
            
            int point = route[aim] - 1;
            int ni = points[point][0] - 1;
            int nj = points[point][1] - 1;
            
            if (ni != ci) {
                if (ni > ci) {
                    ci++;
                } else {
                    ci--;
                }
            } else if (nj != cj) {
                if (nj > cj) {
                    cj++;
                } else {
                    cj--;
                }
            }
            
            if (ni == ci && nj == cj) {
                aim++;
            }
            
            qList[num].add(new int[]{ci,cj});
            // System.out.println(time);
        }
    }
}