// [백준] 그룹 단어 체커
// https://www.acmicpc.net/problem/1316

package week2.string_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int len = str.length();

            loopOut:
            for (int j = 0; j < len-1; j++) {
                char ch = str.charAt(j);

                if (ch != str.charAt(j + 1)) {
                    for (int k = j + 2; k < len; k++) {
                        if (ch == str.charAt(k)) {
                            count++;
                            break loopOut;
                        }
                    }
                }
            }
        }
        System.out.println(N-count);
    }
}
