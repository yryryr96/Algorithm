import java.io.*;
import java.util.*;

public class Main {

    static int x,y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        long z = ((long) y*100)/x;

        if (x == y) System.out.println(-1);
        else {
            int ans = -1;
            int start = 0;
            int end = (int) Math.pow(10,9);
            while (start <= end) {

                int mid = (start + end) / 2;
                if (calc(mid) != z) {
                    ans = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }

    static long calc(int mid) {
        return ((long) (y+mid)*100) / (x+mid);
    }
}