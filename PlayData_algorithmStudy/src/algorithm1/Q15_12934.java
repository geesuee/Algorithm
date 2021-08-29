// [프로그래머스] 정수 제곱근 판별
// https://programmers.co.kr/learn/courses/30/lessons/12934

package algorithm1;

public class Q15_12934 {
    public long solution(long n) {
        Double sqrt = Math.sqrt(n);

        return sqrt == sqrt.intValue()? (long)Math.pow(sqrt+1, 2) : -1;
    }
}
