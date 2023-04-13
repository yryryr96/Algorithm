import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static long A,B,ans;
    static boolean temp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        dfs(A,1);
        if (temp) System.out.println(ans);
        else System.out.println(-1);
    }

    public static void dfs(long num, int cnt){
        if (num > B ) return;
        if (num==B){
            ans = cnt;
            temp = true;
            return;
        }
        dfs(num*2,cnt+1);
        dfs(num*10+1,cnt+1);
    }
}