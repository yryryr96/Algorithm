import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (word.charAt(j) != chars[j]) set.add(j);
            }
        }

        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(i)) sb.append(chars[i]);
            else sb.append("?");
        }

        System.out.println(sb.toString());
    }
}