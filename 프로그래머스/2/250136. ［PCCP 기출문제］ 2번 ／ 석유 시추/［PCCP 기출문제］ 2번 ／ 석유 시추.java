import java.util.*;
class Solution {
    
    static Map<Integer, Integer> groupInfo = new HashMap<>();
    static int[][] visited;
    static int n,m;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new int[n][m];
    // visited를 그룹으로 초기화 -> map에 그룹별 개수 관리
    // 시추하면서 visited좌표가 현재 탐사 그룹이면 continue 다르면 개수 + 
        
        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && visited[i][j] == 0) {
                    getGroupInfo(i,j,num,land);
                    num++;
                }
            }
        }
        
        answer = getAnswer();
        
        // for(int i = 1; i < num; i++) {
        //     // System.out.println(" i = " + i + ", cnt = " + groupInfo.get(i));
        // }
        return answer;
    }
    
    static int getAnswer() {
        
        int res = 0;
        
        for(int j = 0; j < m; j++) {
            
            int curGroup = 0;
            int cnt = 0;
            Set<Integer> s = new HashSet<>();
            for(int i = 0; i < n; i++) {
                if (visited[i][j] != 0) {
                    s.add(visited[i][j]);
                }
            }
            
            for(int a : s) {
                cnt += groupInfo.get(a);
            }
            
            res = Math.max(res, cnt);
        }
        
        return res;
    }
    
    static void getGroupInfo(int sy, int sx, int num, int[][] land) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy,sx));
        visited[sy][sx] = num;
        
        int cnt = 0;
        
        while(!q.isEmpty()) {
            
            Pair cur = q.poll();
            cnt++;
            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                if (inRange(ny,nx) && land[ny][nx] == 1 && visited[ny][nx] == 0) {
                    q.add(new Pair(ny,nx));
                    visited[ny][nx] = num;
                }
            }
        }
        
        groupInfo.put(num, cnt);
    }
    
    static class Pair {
        int y, x;
        Pair (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;        
    }
}