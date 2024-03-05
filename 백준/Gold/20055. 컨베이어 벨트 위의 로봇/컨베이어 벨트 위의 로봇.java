import java.util.*;
import java.io.*;

public class Main {

    static int n,k;
    static int[] durability;
    static boolean[] isOn;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        durability = new int[2*n];
        isOn = new boolean[2*n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        while(true) {

            cnt++;

            // 1단계
            int temp = durability[2*n-1];
            for (int i = 2*n-1; i > 0 ; i--) {
                durability[i] = durability[i-1];
            }
            durability[0] = temp;

            for (int i = n-1; i > 0; i--) {
                isOn[i] = isOn[i-1];
            }

            isOn[0] = false;
            isOn[n-1] = false;

            // 2단계
            for (int i = n-1; i > 0 ; i--) {
                if (isOn[i-1] && !isOn[i] && durability[i] >= 1) {
                    isOn[i] = true;
                    isOn[i-1] = false;
                    durability[i]--;
                    isOn[n-1] = false;
                }
            }

            // 3단계
            if (durability[0] > 0) {
                durability[0]--;
                isOn[0] = true;
            }

            // 4단계
            int c = 0;
            for (int i = 0; i < n * 2; i++) {
                if (durability[i] == 0) c++;
            }

            if (c >= k) break;
        }

        System.out.println(cnt);
    }
}