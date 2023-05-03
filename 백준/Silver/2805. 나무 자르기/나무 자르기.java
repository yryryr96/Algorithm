import com.sun.corba.se.impl.orb.ParserTable;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1000000000;
        int ans = 0;
        while (start<=end) {
            int mid = (start+end)/2;
            long SUM = 0 ;
            for (int tree : trees) {
                if (tree > mid) {
                    SUM += (tree-mid);
                }
            }

            if (SUM < m) {
                end = mid - 1;
            } else if (SUM >= m) {
                ans = mid;
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}