import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (a,b) -> Integer.parseInt(a[0])- Integer.parseInt(b[0]));
        for (String[] row : arr){
            System.out.println(row[0] + " " + row[1]);
        }
    }
}