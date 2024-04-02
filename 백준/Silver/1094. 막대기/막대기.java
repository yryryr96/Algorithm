import java.io.*;
import java.util.*;

public class Main {

    static int x;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < 7; i++) {
            if ((x & (1 << i)) > 0) ans++;
        }

        System.out.println(ans);
    }
}