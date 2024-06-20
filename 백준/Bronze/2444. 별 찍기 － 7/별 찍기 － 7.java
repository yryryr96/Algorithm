import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            String space = " ";
            String star = "*";
            sb.append(space.repeat(n-i));
            sb.append(star.repeat(2*(i-1) + 1));
            sb.append("\n");
        }

        for(int i = 1; i < n; i++) {
            String space = " ";
            String star = "*";
            sb.append(space.repeat(i));
            sb.append(star.repeat(2*(n-i) - 1));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}