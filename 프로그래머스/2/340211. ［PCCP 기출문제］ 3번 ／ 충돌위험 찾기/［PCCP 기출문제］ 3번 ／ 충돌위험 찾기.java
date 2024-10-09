class Solution {
    
    static int[][][] movingHistory = new int[100][100][20000];
    // staitc int[][] map = new int[100][100];
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
//         for (int i = 1; i < points.length; i++) {
//             map[points[i-1][0] - 1][points[i-1][1] - 1] = i;
//         }
        
        for(int[] route : routes) {
            move(route, points);
        }
        
        answer = getAnswer();
        return answer;
    }
    
    static int getAnswer() {
        
        int ans = 0;
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 20000; k++) {
                    if (movingHistory[i][j][k] > 1) ans++;
                }
            }
        }
        
        return ans;
    }
    
    static void move(int[] route, int[][] points) {
        
        int time = 0;
        int aim = 0;
        int ci = points[route[aim] - 1][0] - 1;
        int cj = points[route[aim] - 1][1] - 1;
                
        movingHistory[ci][cj][time]++;
        aim++;
        
        while (aim < route.length) {
            
            time++;
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
            
            movingHistory[ci][cj][time]++;
            // System.out.println(time);
        }
    }
}