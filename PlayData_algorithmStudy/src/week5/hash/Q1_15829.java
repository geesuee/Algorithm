// [백준] Hashing
// https://www.acmicpc.net/problem/15829
// 50점짜리 답안..뭐가 문제지..

package week5.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_15829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int M = 1234567891;
        String string = br.readLine();

        long hash = 0;
        for(int i = 0; i < L; i++) {
            hash += (string.charAt(i) - 96) * Math.pow(31, i);
            hash %= M;
        }

        System.out.println(hash);
    }
}
