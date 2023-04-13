import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <n ; i++) {
            int cnt = 0;
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length ; j++) {
                if (arr[j] == '(') cnt += 1;
                else cnt -= 1;

                if (cnt < 0 ) {
                    break;
                }
            }
            if (cnt==0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}