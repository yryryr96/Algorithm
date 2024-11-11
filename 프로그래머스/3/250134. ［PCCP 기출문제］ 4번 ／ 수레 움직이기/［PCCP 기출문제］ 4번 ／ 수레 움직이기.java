import java.util.*;

class Solution {
    
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int by,bx,ry,rx,bey,bex,rey,rex;
    static int n,m;
    static List<List<Pair>> blueRoads = new ArrayList<>();
    static List<List<Pair>> redRoads = new ArrayList<>();
    static boolean[][] visited;
        
    public int solution(int[][] maze) {
        int answer = 0;
        
        n = maze.length;
        m = maze[0].length;
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int v = maze[i][j];
                if(v == 1) {
                    ry = i; rx = j;
                } else if (v == 2) {
                    by = i; bx = j;
                } else if (v == 3) {
                    rey = i; rex = j;
                } else if (v == 4) {
                    bey = i; bex = j;
                }
            }
        }
        
        List<Pair> redRoad = new ArrayList<>();
        List<Pair> blueRoad = new ArrayList<>();
        redRoad.add(new Pair(ry, rx));
        blueRoad.add(new Pair(by, bx));
        
        
        visited[ry][rx] = true;
        dfs(ry, rx, rey, rex, maze, redRoad, redRoads);
        visited[ry][rx] = false;
        
        // visited = new boolean[n][m];
        visited[by][bx] = true;
        dfs(by, bx, bey, bex, maze, blueRoad, blueRoads);
        visited[by][bx] = false;
        
        answer = getAnswer();
        
        return answer;
    }
    
    static void printRoad(List<Pair> r) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r.size(); i++) {
            sb.append(r.get(i).y + " " + r.get(i).x).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    static int getAnswer() {
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < redRoads.size(); i++) {
            for(int j = 0; j < blueRoads.size(); j++) {
                if(canRoad(redRoads.get(i), blueRoads.get(j))) {
                    int cnt = Math.max(redRoads.get(i).size(), blueRoads.get(j).size());
                    ans = Math.min(ans, cnt - 1);
//                     if(i == 0 && j == 6) {
//                         System.out.println("red");
//                         printRoad(redRoads.get(i));
                        
//                         System.out.println("blue");
//                         printRoad(blueRoads.get(j));
                        
//                     }
                    System.out.println("i = " + i + " j = " + j + " cnt: " + cnt + " ans : " + ans);
                }
            }
        }
        
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
    
    static boolean canRoad(List<Pair> red, List<Pair> blue) {
        
//         for(int i = 0; i < red.size(); i++) {
//             Pair r = red.get(i);
//             for(int j = 0; j < blue.size(); j++) {
                
//                 Pair b = blue.get(j);
                
//                 // 동시에 같은 좌표로 이동
//                 if(i == j && r.y == b.y && r.x == b.x) return false;
                
//                 // 자리 바꾸면서 이동
//                 if(i < red.size() - 1 && j < blue.size() - 1)  {
//                     Pair nr = red.get(i+1);
//                     Pair nb = blue.get(j+1);
                    
//                     if(nr.y == b.y && nr.x == b.x && nb.y == r.y && nb.x == r.x) return false;
//                 }
                
//                 // blue 도착해서 이미 고정인 상태
//                 if(red.size() >= blue.size() && i >= blue.size() - 1) {
//                     if (r.y == bey && r.x == bex) return false;
//                 }
                
//                 // red 도착해서 이미 고정
//                 if(red.size() <= blue.size() && j >= red.size() - 1) {
//                     if (b.y == rey && b.x == rex) return false;
//                 }
//             }
//         }
        
        for(int i = 0; i < Math.max(red.size(), blue.size()); i++) {
            
            Pair r,b;
            
            if(i < red.size()) r = red.get(i);
            else r = red.get(red.size() - 1);
            
            if(i < blue.size()) b = blue.get(i);
            else b = blue.get(blue.size() - 1);
            
            // 동시에 같은 좌표로 이동
            if(r.y == b.y && r.x == b.x) return false;
            
            // 자리 바꾸면서 이동
            if(i < red.size() - 1 && i < blue.size() - 1)  {
                Pair nr = red.get(i+1);
                Pair nb = blue.get(i+1);

                if(nr.y == b.y && nr.x == b.x && nb.y == r.y && nb.x == r.x) return false;
            }   
        }
        
        
        return true;
    }
    
    static void dfs(int y, int x, int ty, int tx, int[][] maze, List<Pair> road, List<List<Pair>> result) {
        
        if(y == ty && x == tx) {
            // 경로 add 로직
            result.add(road);
            return;
        }
        
        for(int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            
            if(!inRange(ny,nx) || visited[ny][nx]) continue;
            if(maze[ny][nx] == 5) continue;
            
            visited[ny][nx] = true;
            List<Pair> temp = new ArrayList<>(road);
            temp.add(new Pair(ny,nx));
            dfs(ny, nx, ty, tx, maze, temp, result);
            visited[ny][nx] = false;
        }
    }
    
    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}