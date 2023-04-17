import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static boolean[] visited;
    static int n;
    static StringBuilder sb;
    static int[] lst;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0 ) break;
            arr = new int[n] ;
            lst = new int[n] ;
            visited = new boolean[n];
            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            System.out.println(sb);
        }
    }

    public static void dfs(int idx, int depth){
        if (depth == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(lst[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                lst[depth] = arr[i];
                dfs(i,depth+1);
                visited[i] = false;
            }
        }
    }
}