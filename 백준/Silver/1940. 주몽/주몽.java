import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());
        int m = stoi(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] + arr[j] == m) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}