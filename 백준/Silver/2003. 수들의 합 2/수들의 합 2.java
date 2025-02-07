import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int end = 0;

        int sum = 0;
        int answer = 0;
        for (int start = 0; start < n; start++) {

            while(end < n && sum < m) {
                sum += arr[end];
                end++;
            }

            if (sum == m) answer++;

            sum -= arr[start];
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}