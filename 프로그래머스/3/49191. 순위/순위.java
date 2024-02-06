class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];
        int answer = 0;
        
        for (int[] res : results) {
            win[res[0]][res[1]] = true;
            lose[res[1]][res[0]] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    
                    if (i == j) continue;
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                        lose[j][i] = true;
                    }
                    
                    if (lose[i][k] && lose[k][j]) {
                        win[j][i] = true;
                        lose[i][j] = true;
                    }
                }
            }
        }
        
        for (int i = 1; i < n+1; i++) {
            int cnt = 0;
            for (int j = 1; j < n+1; j++) {
                if (win[i][j] || lose[i][j]) cnt++;
            }
            if (cnt == n-1) answer++;
        }
        
        return answer;
    }
}