import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        int[][] apt = new int[15][15];
        int[][] psum = new int[15][15];

        for (int col = 1; col < 15; col++) {
            apt[0][col] = col;
            psum[0][col] = psum[0][col - 1] + apt[0][col];
        }

        for (int row = 1; row < 15; row++) {
            for(int col = 1; col < 15; col++) {
                apt[row][col] = psum[row-1][col];
                psum[row][col] = psum[row][col - 1] + apt[row][col];
            }
        }

        for (int tc = 1; tc <= T; tc++) {
            int k = stoi(br.readLine());
            int n = stoi(br.readLine());
            System.out.println(apt[k][n]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
