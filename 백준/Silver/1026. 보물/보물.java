import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b,Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i <n ; i++) {
            ans += (a[i]*b[i]);
        }
        System.out.println(ans);
        
    }
}