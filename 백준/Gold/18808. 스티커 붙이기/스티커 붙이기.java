import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Main {

    static int n,m,k;
    static List<int[][]> stickers = new ArrayList<>();
    static int[][] notebook;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        notebook = new int[n][m];

        for (int i = 0; i < k; i++) {

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] map = new int[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < c; l++) {
                    map[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(map);
        }


//        int[][] rotation90 = rotation(map, n, m);
//        int[][] rotation180 = rotation(rotation90, m, n);
//        int[][] rotation270 = rotation(rotation180, n, m);
        putSticker();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (notebook[i][j] == 1) ans++;
            }
        }

        System.out.println(ans);
    }

    static void putSticker() {

        for (int[][] sticker : stickers) {
            if (isValid(sticker)) continue;
            int[][] rotation90 = rotation(sticker, sticker.length, sticker[0].length);
            if (isValid(rotation90)) continue;
            int[][] rotation180 = rotation(rotation90, rotation90.length, rotation90[0].length);
            if ((isValid(rotation180))) continue;
            int[][] rotation270 = rotation(rotation180, rotation180.length, rotation180[0].length);
            if ((isValid(rotation270))) continue;
        }
    }

    static boolean isValid(int[][] sticker) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (draw(sticker, i, j)) {
                    for (int l = 0; l < sticker.length; l++) {
                        for (int o = 0; o < sticker[0].length; o++) {
                            if (sticker[l][o] == 1 && notebook[i + l][j + o] == 0) notebook[i + l][j + o] = 1;
                        }
                    }

                    return true;
                }
            }
        }

        return false;
    }

    static boolean draw(int[][] sticker, int si, int sj) {
        if (!isRange(si+sticker.length-1, sj + sticker[0].length-1)) return false;

        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1 && notebook[si+i][sj+j] == 1) return false;
            }
        }

        return true;
    }

    static boolean isRange(int i, int j) {
        return 0 <= i && 0 <= j && i < n && j < m;
    }

    static int[][] rotation(int[][] map, int r, int c) {

        int[][] temp = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[j][r-1-i] = map[i][j];
            }
        }

        return temp;
    }
}