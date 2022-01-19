// [백준] 뒤집기
// https://www.acmicpc.net/problem/1439

package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int groupOne = 0;
        int groupZero = 0;

        if (S.charAt(0) == '1') {
            groupOne = 1;
        } else {
            groupZero = 1;
        }

        for (int i = 0; i < S.length()-1; i++) {
            if (S.charAt(i) != S.charAt(i+1)) {
                if (S.charAt(i+1) == '1') {
                    groupOne++;
                } else {
                    groupZero++;
                }
            }
        }

        System.out.println(Math.min(groupOne, groupZero));
    }
}
