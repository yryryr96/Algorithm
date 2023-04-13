import com.sun.corba.se.impl.orb.ParserTable;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input = br.readLine()).equals(".") ){
            int temp = 1;
            char[] ch = input.toCharArray();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i <ch.length ; i++) {
                if (ch[i] == '(') stack.push("(");
                else if (ch[i] == '[') stack.push("[");
                else if (ch[i] ==')') {
                    if (stack.size() == 0){
                        temp = 0;
                        break;
                    }
                    if (stack.peek().equals("(")) stack.pop();
                    else {
                        temp = 0;
                        break;
                    }
                }
                else if (ch[i] == ']'){
                    if (stack.size() == 0){
                        temp = 0;
                        break;
                    }
                    if (stack.peek().equals("[")) stack.pop();
                    else {
                        temp = 0;
                        break;
                    }
                }
            }
            if (stack.size() > 0 || temp == 0) System.out.println("no");
            else System.out.println("yes");
        }

    }
}