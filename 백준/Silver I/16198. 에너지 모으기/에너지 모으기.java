import java.util.*;
import java.io.*;

public class Main {

    static int max = 0;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        dfs(arr, 0);
        System.out.println(max);
    }

    static void dfs(List<Integer> arr, int sum) {

        if (arr.size() == 2) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 1; i < arr.size()-1; i++) {
            int v = arr.get(i);
            int temp = sum;
            sum += (arr.get(i-1) * arr.get(i+1));
            arr.remove(i);
            dfs(arr, sum);
            sum = temp;
            arr.add(i, v);
        }
    }
}