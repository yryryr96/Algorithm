class Solution {
        
    static boolean[][] visited;
    static int cnt;

    public int solution(int n, int[][] wires) {
        int answer = 0;
        int min = 9999;
        visited = new boolean[n+1][n+1];
        for (int[] wire : wires) {
            visited[wire[0]][wire[1]] = true;
            visited[wire[1]][wire[0]] = true;
        }
        
        for (int[] wire : wires) {
            cnt = 0;
            visited[wire[0]][wire[1]] = false;
            visited[wire[1]][wire[0]] = false;
            dfs(wires, wire[0], n);
            visited[wire[0]][wire[1]] = true;
            visited[wire[1]][wire[0]] = true;
            min = Math.min(min, Math.abs(2*cnt - n));
        }
        
        answer = min;
        return answer;
    }
    
    private static void dfs(int[][] wires, int node, int n) {

        cnt++;
        
        for (int i = 1; i < n+1; i++) {
            if (visited[node][i]) {
                visited[node][i] = false;
                visited[i][node] = false;
                dfs(wires, i, n);
                visited[i][node] = true;
                visited[node][i] = true;
            }
        }
    }
}