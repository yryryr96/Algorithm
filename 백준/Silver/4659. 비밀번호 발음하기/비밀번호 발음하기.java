
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String END_COMMAND = "end";
    public static final String[] vowels = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String password = br.readLine();

            if (END_COMMAND.equals(password)) {
                break;
            }

            if (!containVowels(password, vowels)) {
                printNotAcceptable(password);
                continue;
            }

            if (password.length() >= 3 && !checkStreamThree(password)) {
                // 출력
                printNotAcceptable(password);
                continue;
            }

            if (password.length() >= 2 && !checkContinuousChar(password)) {
                // 출력
                printNotAcceptable(password);
                continue;
            }

            printAcceptable(password);
        }
    }

    static void printNotAcceptable(String password) {
        System.out.println("<" + password + "> is not acceptable.");
    }

    static void printAcceptable(String password) {
        System.out.println("<" + password + "> is acceptable.");
    }

    static boolean containVowels(String password, String[] vowels) {

        for (String vowel : vowels) {
            if (password.contains(vowel)) {
                return true;
            }
        }

        return false;
    }

    static boolean checkStreamThree(String password) {

        for (int i = 0; i < password.length()-2; i++) {

            int vowelCount = 0;
            int consonantCount = 0;

            for (int j = 0; j <= 2; j++) {
                for (String vowel : vowels) {
                    if (password.charAt(i+j) == vowel.charAt(0)) {
                        vowelCount++;
                    }
                }

                if (vowelCount == 0) {
                    consonantCount++;
                }
            }
//            System.out.println("vowelCount: " + vowelCount + ", consonantCount: " + consonantCount);
            if (vowelCount >= 3 || consonantCount >= 3) {
                return false;
            }
        }

        return true;
    }

    static boolean checkContinuousChar(String password) {

        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i+1) && password.charAt(i) != 'e' && password.charAt(i) != 'o') {
                return false;
            }
        }

        return true;
    }
}
