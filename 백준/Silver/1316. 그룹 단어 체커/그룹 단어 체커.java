import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int ans = t;

        for (int i = 0; i < t ; i++) {
            String word = br.readLine();
            boolean[] alphabet = new boolean[26] ;
            char now = word.charAt(0);

            for (int j = 0; j < word.length() ; j++) {
                if (now != word.charAt(j)){
                    if (alphabet[word.charAt(j)-97]) {
                        ans --;
                        break;
                    }
                    alphabet[now-97] = true;
                }
                now = word.charAt(j);
            }
        }
        System.out.println(ans);
    }
}