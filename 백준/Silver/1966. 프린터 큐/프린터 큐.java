import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i <t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int max = 0 ;
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int[] importance = new int[10];
            Deque<Integer> q = new ArrayDeque<>();
            for (int j = 0; j <n ; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                importance[num] += 1;
                q.add(j);
                if (num > max ) max = num ;
            }

            int cnt = 1;
            int now = max;

            while ( now >= arr[m]){
                while( importance[now] > 0) {
                    if (arr[q.peekFirst()] == now) {
                        if (q.pollFirst() == m ) break;
                        importance[now] -= 1;
                        cnt += 1;
                    } else{
                        int temp = q.pollFirst();
                        q.add(temp);
                    }
                }
                now -= 1;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}