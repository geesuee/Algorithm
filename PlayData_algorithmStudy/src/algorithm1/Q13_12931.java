// [프로그래머스] 자릿수 더하기
// https://programmers.co.kr/learn/courses/30/lessons/12931

package algorithm1;

public class Q13_12931 {
    public int solution(int n) {
        String number = Integer.toString(n);
        int answer = 0;

        for(int i = 0; i < number.length(); i++) {
            answer += number.charAt(i) - '0';
        }
        return answer;
    }
}
