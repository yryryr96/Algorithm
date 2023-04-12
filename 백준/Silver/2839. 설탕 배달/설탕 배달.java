import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        int cnt = Integer.MAX_VALUE;

        for (int i = 0; i < (w/3)+1; i++) {
            for (int j = 0; j < w/5+1; j++) {
                if (i*3 + 5*j == w) {
                    if (cnt > (i+j)) cnt = i+j;
                }
                else if(i*3+5*j > w) break;
            }
        }
        if (cnt == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(cnt);
    }
}