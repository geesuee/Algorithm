// [프로그래머스] 약수의 합
// https://programmers.co.kr/learn/courses/30/lessons/12928

package algorithm1;

public class Q4_12928 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
