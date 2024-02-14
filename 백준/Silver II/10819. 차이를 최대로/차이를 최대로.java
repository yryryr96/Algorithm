import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static int[] arr;
    static int[] lst;
    static int n;
    static int sum ;
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sum = 0;
        visited = new boolean[n];
        lst = new int[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(sum);
    }

    public static void dfs(int idx,int depth){
        if (depth == n){
            int s = 0;
            for (int i = 0; i <n-1; i++) {
                s += Math.abs(arr[i]-arr[i+1]);
            }
            if (s > sum) sum = s;
            return;
        }

        for (int i = 0; i < n ; i++) {
            if (!visited[i]){
                visited[i] = true;
                arr[depth] = lst[i];
                dfs(i,depth+1);
                visited[i] = false;
            }
        }
    }

}