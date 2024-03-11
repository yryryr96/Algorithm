import java.io.*;
import java.util.*;

public class Main {

    static int tc;
    static int n,m;
    static int[] note1, note2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < tc; k++) {


            n = Integer.parseInt(br.readLine());
            note1 = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());
            note2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                note2[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);

            for (int i = 0; i < m; i++) {
                sb.append(binarySearch(note2[i]) ? 1 : 0);
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static boolean binarySearch(int target) {

        int start = 0;
        int end = n-1;

        while (start <= end) {

            int mid = (start + end) / 2;
            if (target == note1[mid]) return true;
            else if(target < note1[mid]) {
                end = mid - 1;
            } else if (target > note1[mid]) {
                start = mid + 1;
            }
        }

        return false;
    }
}