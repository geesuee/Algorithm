// [백준] 피보나치 수 5
// https://www.acmicpc.net/problem/10870

package week2.string_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fb(n));
    }

    public static int fb(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fb(n-1) + fb(n-2);
        }
    }
}
