import java.util.*;
import java.io.*;

public class Main {

    static HashMap<Character, Integer> map = new HashMap<>();
    static int ans = 0;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < str.length; j++) {
                int temp = map.getOrDefault(str[j],0);
                map.put(str[j], temp + (int) Math.pow(10, str.length - 1 - j));
            }
        }

        List<Character> arr = new ArrayList<>(map.keySet());
        arr.sort((a,b) -> map.get(b) - map.get(a));

        int num = 9;
        for (int i = 0; i < arr.size(); i++) {

            ans += map.get(arr.get(i)) * num;
            num--;
        }
        
        System.out.println(ans);
    }
}