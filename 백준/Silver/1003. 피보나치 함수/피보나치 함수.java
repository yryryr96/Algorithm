import java.io.*;
import java.util.*;

public class Main {

    static int[] zero = new int[41];
    static int[] one = new int[41];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        fibonacci();

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());
            sb.append(zero[n] + " " + one[n]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void fibonacci() {

        zero[0] = 1;
        one[0] = 0;
        zero[1] = 0;
        one[1] = 1;
        zero[2] = 1;
        one[2] = 1;

        for (int i = 3; i < 41; i++) {

            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }
    }
}