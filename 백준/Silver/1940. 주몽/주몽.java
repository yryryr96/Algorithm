import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        Arrays.sort(arr);

        int answer = 0;
        int left = 0;
        int right = n-1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum > m) {
                right--;
            } else if (sum < m) {
                left++;
            } else {
                answer++;
                left++;
            }
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}