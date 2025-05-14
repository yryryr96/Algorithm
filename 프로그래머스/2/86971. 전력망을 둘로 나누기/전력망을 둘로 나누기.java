import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer = 10000;
    static int N;
    public int solution(int n, int[][] wires) {
        
        N = n;
        visited = new boolean[N];
        
        for(int i = 0; i < n-1; i++) {
            initVisited();
            
            visited[i] = true;
            int a = getAnswer(wires[i][0], wires);
            visited[i] = false;
            
            int b = n - a;
            answer = Math.min(Math.abs(a - b), answer);
        }
//         if (N < 5) return 0;
        
//         visited[5] = true;
//         int a = getAnswer(4, wires);
//         visited[5] = false;
//         int b = n - a;

//         System.out.print("a= " + a);
//         System.out.print("b= " + b);
        
        return answer;
    }
    
    static void initVisited() {
        Arrays.fill(visited, false);
    }
    
    static int getAnswer(int node, int[][] wires) {
        
        boolean flag = false;
        int sum = 1;
        
        for(int i = 0; i < N-1; i++) {
            if(!visited[i]) {
                if (wires[i][0] == node || wires[i][1] == node) {
                    int nextNode = wires[i][0] == node ? wires[i][1] : wires[i][0];
                    flag = true;
                    visited[i] = true;
                    sum += getAnswer(nextNode, wires);
                }
            }
        }
        
        if (flag) {
            return sum;
        } 
        
        return 1;
    }
}