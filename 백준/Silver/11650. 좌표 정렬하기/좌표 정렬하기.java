import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {x,y};
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {

                int com = Integer.compare(p1[0], p2[0]);
                if (com == 0) {

                    return Integer.compare(p1[1], p2[1]);
                }
                return com;
            }
        });

        for (int[] a : arr){
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.println(sb);
    }
}