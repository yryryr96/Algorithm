import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int A;
        int B;
        int C;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println( (A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}