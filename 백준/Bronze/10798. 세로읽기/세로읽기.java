import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] ch = new char[5][15];
        int max = 0;

        for (int i = 0; i <5 ; i++) {
            String str = br.readLine();
            if (max < str.length()) max = str.length();
            for (int j = 0; j <str.length() ; j++) {
                ch[i][j] = str.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <max ; j++) {
            for (int i = 0; i < 5 ; i++) {
                if (ch[i][j] == '\0') continue;
                sb.append(ch[i][j]);
            }
        }
        System.out.println(sb);
    }
}