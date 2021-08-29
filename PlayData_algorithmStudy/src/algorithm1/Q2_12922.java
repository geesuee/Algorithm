// [프로그래머스] 수박수박수박수박수박수?
// https://programmers.co.kr/learn/courses/30/lessons/12922

package algorithm1;

public class Q2_12922 {
    public String solution(int n) {
        String answer = "";

        for (int i = 0; i < n; i++){
            if(i%2 == 0) { answer += "수"; }
            else { answer += "박"; }
        }

        return answer;
    }
}
