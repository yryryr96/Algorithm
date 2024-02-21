import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = n + m;

        List<Integer> numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {

            sb.append(numbers.get(i) + " ");
        }

        System.out.println(sb.toString());
    }
}