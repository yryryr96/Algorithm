import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            a-=1;
            int b = Integer.parseInt(st.nextToken());
            b-=1;
            int c = Integer.parseInt(st.nextToken());
            for (int j = a; j < b+1 ; j++) {
                num[j] = c;
            }
        }
        for (int s:num){
            System.out.print(s + " ");
        }
    }
}