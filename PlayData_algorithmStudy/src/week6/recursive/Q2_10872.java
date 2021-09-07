// [백준] 팩토리얼
// https://www.acmicpc.net/problem/10872
/**
 * 팩토리얼의 경우,
 * 결과값이 매우 커질 수 있으므로 가급적 long 사용
 */

package week6.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(N));
    }

    static Long factorial(int N) {
        if(N <= 1) {
            return 1L;
        }
        return N * factorial(N-1);
    }
}
