// [프로그래머스] 평균 구하기
// https://programmers.co.kr/learn/courses/30/lessons/12944

package algorithm1;

public class Q10_12944 {
    public double solution(int[] arr) {
        double answer = 0;
        int s = 0;
        for(int num : arr) {
            s += num;
            answer = (double)s/(double)arr.length;
        }
        return answer;
    }
}
