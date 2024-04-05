import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] selected;
    static int n;
    static int maxWin = 0;
    static List<Integer> A,B,answer;
    
    public int[] solution(int[][] dice) {
        
        n = dice.length;
        selected = new boolean[n];
        combination(0,0,dice);
        return answer.stream().mapToInt(x->x).toArray();
    }
    
    static void combination(int depth, int idx, int[][] dice) {
        
        if (depth == n/2) {
            
            int win = 0;
            A = new ArrayList<>();
            B = new ArrayList<>();

            permutation(0, 0, true, 0, dice);
            permutation(0, 0, false, 0, dice);
            
            System.out.println("A.size() = " + A.size());
            System.out.println("B.size() = " + B.size());
            Collections.sort(A);
            Collections.sort(B);

            for (int i = 0; i < A.size(); i++) {
                int v = A.get(i);
                win += binarySearch(v);
            }
            
            if (win > maxWin) {
                answer = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if(selected[i] == true) answer.add(i+1);
                }
                maxWin = win;
            }
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                combination(depth+1, i+1, dice);
                selected[i] = false;
            }
        }
    }
    
    static int binarySearch(int target) {
        
        int start = 0;
        int end = B.size() - 1;
        int mid = (start + end) / 2;
        
        while (start <= end) {
            
            mid = (start + end) / 2;
            if (B.get(mid) >= target) end = mid - 1;
            else start = mid + 1;
        }
        
        return start;
    }
    
    static void permutation(int depth, int idx, boolean temp, int value, int[][] dice) {
        
        if (depth == n/2) {
            if (temp == false) B.add(value);
            else A.add(value);
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (selected[i] == temp) {
                for (int j = 0; j < 6; j++) {
                    // System.out.println("depth = " + depth + "temp = " + temp + " i = " + i + " j = " + j);
                    permutation(depth+1, i+1, temp, value + dice[i][j], dice);
                }
            }
        }
    }
}