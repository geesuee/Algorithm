// [백준] 이진수 변환
// https://www.acmicpc.net/problem/10829
/**
 * toBinaryString으로 풀면 짧은 코드로 풀 수 있지만,
 * 재귀함수를 사용을 연습하기 위해 이진수 변환 알고리즘을 짜보았다.
 *
 * 주의할 점
 * - int / 32 bits / -2147483648 ~ 2147483647 (10자리)
 * - long / 64 bits / -9223372036854775808 ~ 9223372036854775807 (19자리)
 */
package week6.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_10829_recursive {
        static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = Long.parseLong(br.readLine());
        System.out.println(toBinay(N));
    }

    static String toBinay(Long N) {
        if(N == 1) {
            sb.append(N);
            return sb.reverse().toString();
        }
        if(N == 0) {
            return sb.reverse().toString();
        }

        sb.append(N % 2);
        N /= 2;
        return toBinay(N);
    }
}
