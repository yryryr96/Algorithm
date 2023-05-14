import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Deque<Integer> q = new ArrayDeque<>();
        q.push(n);

        while(!q.isEmpty()){
            int num = q.removeFirst();
//            System.out.println(num);
            if (num == 1) {
                System.out.println(dp[1]);
                break;
            }

            if (num%2 == 0 ){
                if (dp[num/2] == 0 || dp[num/2] > dp[num] + 1){
                    dp[num/2] = dp[num] + 1;
                    q.add(num/2);
                }
            }

            if (num%3 == 0 ){
                if (dp[num/3] == 0 || dp[num/3] > dp[num] + 1){
                    dp[num/3] = dp[num] + 1;
                    q.add(num/3);
                }
            }
            if (dp[num-1] == 0 || dp[num-1] > dp[num] + 1){
                dp[num-1] = dp[num] + 1;
                q.add(num-1);
            }
        }

    }
}