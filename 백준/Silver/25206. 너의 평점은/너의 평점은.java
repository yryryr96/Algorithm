import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input="";
        float cnt = 0;
        float ans = 0;
        for (int i = 0; i < 20 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String sub = st.nextToken();
            if (sub.equals("A+")){
                ans+=4.5*score;
            }else if(sub.equals("A0")){
                ans+=4.0*score;
            }else if(sub.equals("B+")){
                ans+=3.5*score;
            }else if(sub.equals("B0")){
                ans+=3.0*score;
            }else if(sub.equals("C+")){
                ans+=2.5*score;
            }else if(sub.equals("C0")){
                ans+=2.0*score;
            }else if(sub.equals("D+")){
                ans+=1.5*score;
            }else if(sub.equals("D0")){
                ans+=1.0*score;
            }else if(sub.equals("F")){
                ans+=0;
            }else if(sub.equals("P")){
                continue;
            }
            cnt += score;
        }
        System.out.println(String.format("%.6f",ans/cnt));
    }
}