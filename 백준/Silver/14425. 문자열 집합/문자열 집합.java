import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        String[] str = new String[n];

        for (int i = 0; i <n ; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i <m ; i++) {
            String check = br.readLine();
            for (int j = 0; j <n ; j++) {
                if (str[j].equals(check)) {
                    ans +=1;
                }
            }
        }
        System.out.print(ans);
    }
}