import java.io.*;
import java.util.*;

public class Main {

    static int h,w,x,y;
    static int[][] A,B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        A = new int[h][w];
        B = new int[h+x][w+y];

        for (int i = 0; i < h+x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w+y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                calc(i,j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void calc(int i, int j) {

        if (B[i][j] == 0) return;
        if (x <= i && i <= h && y <= j && j <= w) {
            A[i][j] = B[i][j] - A[i-x][j-y];
        } else {
            A[i][j] = B[i][j];
        }
    }
}