// [프로그래머스] x만큼 간격이 있는 n개의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12954

package algorithm1;

public class Q8_12954 {
    public static long[] solution(long x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++){
            answer[i] = x * (i+1);
        }
        return answer;
    }
}
