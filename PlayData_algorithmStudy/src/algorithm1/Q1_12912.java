// [프로그래머스] 두 정수 사이의 합
// https://programmers.co.kr/learn/courses/30/lessons/12912

package algorithm1;

public class Q1_12912 {
    public long solution(int a, int b) {
        long answer = 0;

        if(a < b){
            for(int i = a; i <= b; i++)
                answer += i;
        }
        else{
            for(int i = b; i <= a; i++)
                answer += i;
        }

        return answer;
    }
}
