// [백준] 팩토리얼
// https://www.acmicpc.net/problem/10872

package week2.string_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }
}
