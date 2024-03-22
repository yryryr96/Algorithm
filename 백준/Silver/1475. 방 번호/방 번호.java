import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split("");

        int[] count = new int[10];
        for (int i = 0; i < number.length; i++) {
            String s = number[i];
            count[Integer.parseInt(s)] ++;
        }

        int sum = count[6] + count[9];
        if (sum != 0) {
            if (sum % 2 == 0) {
                count[6] = sum/2;
                count[9] = sum/2;
            } else {
                count[6] = sum/2 + 1;
                count[9] = sum - count[6];
            }
        }

        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            ans = Math.max(ans, count[i]);
        }

        System.out.println(ans);
    }
}