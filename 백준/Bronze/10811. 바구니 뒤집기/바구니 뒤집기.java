import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];

        for (int i = 0; i <N ; i++) {
            num[i] = i+1;
        }

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a-=1;
            b-=1;
            while (a<b) {
                int temp;
                temp = num[a];
                num[a] = num[b];
                num[b] = temp;
                a += 1;
                b -= 1;
            }
        }
        for (int s :num){
            System.out.print(s + " ");
        }
    }
}