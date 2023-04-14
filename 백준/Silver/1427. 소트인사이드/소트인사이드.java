import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int n = number.length();
        char[] ch = number.toCharArray();
        Arrays.sort(ch);

        String ans = new String(ch);
        ans = new StringBuilder(ans).reverse().toString();
        System.out.println(ans);

    }
}