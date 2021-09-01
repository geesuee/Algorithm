// [백준] Hashing
// https://www.acmicpc.net/problem/15829
/**
 * 50점짜리 답안이 나오는 이유!
 * 원인 1 : Math.pow() 메소드의 사용
 * Math.pow() 는 거듭제곱 연산값을 double로 반환하는 메소드
 * 그런데! 숫자가 많이 커지면, 일정 부분 숫자를 올림 처리하여 정확하지 않은 값을 반환!!!
 * 때문에 숫자가 많이 켜졌을 경우, 올림 처리된 값을 곱하여 오류 발생
 * 아래와 같이 pow를 변수로 만들고 이를 반복문 내부에서 계속 갱신해주면 해결됨
 *
 * 원인 2 : mod 연산 미포함
 * 혹시 위 방법으로 해결이 되지 않는다면,
 * pow와 hash 결과 값을 M 값으로 나누어주는 mod 연산을 했는지 확인
 * 거듭제곱 연산이 포함된 만큼 pow와 hash 값이 매우 커질 수 있기 때문에 두 값 모두 mod 연산을 해주어야 함
 */

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
        long pow = 1;
        for(int i = 0; i < L; i++) {
            hash += (string.charAt(i) - 96) * pow;
            pow = (pow *= 31) % M;
        }

        System.out.println(hash % M);
    }
}
