import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = str.length();
        int num = Integer.parseInt(str);
        int cnt = 1;
        long ans = 0;

        if (num < 10) {
            System.out.println(num);
        } else {
            while (n > 0) {
                if (cnt == 1) {
                    ans += n * (num - Math.pow(10,n-1) + 1);
                }

                else {
                    ans += n * 9 * Math.pow(10, n-1);
                }

                cnt++;
                n--;
            }

            System.out.println(ans);
        }

    }
}