import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int[] plus = new int[10000001];
       int[] minus = new int[10000001];
       int n = Integer.parseInt(br.readLine());
       st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a >= 0) {
                plus[a] += 1;
            }else {minus[-a] += 1;}

        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i <m ; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (k>=0){
                sb.append(plus[k]).append(" ");
            }
            else{sb.append(minus[-k]).append(" ");}
        }

        System.out.println(sb);
    }
}