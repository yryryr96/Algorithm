import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = stoi(st.nextToken());
        int W = stoi(st.nextToken());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int height = (H-1) / (N+1) + 1;
        int width = (W-1) / (M+1) + 1;
        int answer = height * width;
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
