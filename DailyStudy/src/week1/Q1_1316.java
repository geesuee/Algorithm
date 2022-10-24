// [백준] 그룹 단어 체커
// https://www.acmicpc.net/problem/1316

package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int notGroupWord = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int len = word.length();
            char[] charArray = word.toCharArray();

            loop: for (int j = 0; j < len-1; j++) {
                char prev = charArray[j];
                char next = charArray[j + 1];
                if (prev != next) {
                    for (int k = j + 2; k < len; k++) {
                        if (prev == charArray[k]) {
                            notGroupWord++;
                            break loop;
                        }
                    }
                }
            }
        }

        System.out.println(N-notGroupWord);
    }
}
