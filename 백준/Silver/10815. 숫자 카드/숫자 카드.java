import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <m ; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(number,k) >= 0){
                sb.append(1).append(" ");
            }
            else sb.append(0).append(" ");
        }
        System.out.println(sb.toString());

    }
}