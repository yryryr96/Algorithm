import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] A,B;
    static int ans = 0;
    static int temp = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        B = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int b = Integer.parseInt(st.nextToken());
            int tmp = 0;
            while (b>0) {
                if (b%2 == 1) {
                    b--;
                    ans++;
                } else {
                    b /= 2;
                    tmp ++;
                }
            }

            temp = Math.max(temp, tmp);
        }

        System.out.println(ans + temp);
    }
}