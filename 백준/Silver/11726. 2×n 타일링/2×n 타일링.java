import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] f;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        f = new int[1001];
        init();
        System.out.println(f[n]);
    }

    static void init() {

        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            f[i] = (f[i-1] + f[i-2]) % 10007;
        }
    }
}