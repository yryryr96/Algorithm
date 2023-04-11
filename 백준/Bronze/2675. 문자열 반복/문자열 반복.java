
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i <t ; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            String result = "";
            for (int j = 0; j < word.length() ; j++) {
                for (int k = 0; k <r ; k++) {
                    result += word.charAt(j);
                }
            }
            System.out.println(result);
        }

    }
}