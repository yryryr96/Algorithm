import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a, b;
        int arr[] = new int[4];
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        arr[0] = b%10;
        arr[1] = (b%100)/10;
        arr[2] = b/100;
        arr[3] = b;
        for (int i = 0; i < 4 ; i++) {
            System.out.println(arr[i]*a);
        }
    }
}