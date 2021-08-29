// [프로그래머스] 서울에서 김서방 찾기
// https://programmers.co.kr/learn/courses/30/lessons/12919

package algorithm1;

public class Q3_12919 {
    public String solution(String[] seoul) {
        String answer = "";

        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer += "김서방은 " + i + "에 있다";
            }
        }

        return answer;
    }
}
