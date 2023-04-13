import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <n ; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num==0) stack.pop();
            else stack.push(num);
        }

        int ans = 0;
        for (int i = 0; i < stack.size() ; i++) {
            ans += stack.get(i);
        }
        System.out.println(ans);
    }
}