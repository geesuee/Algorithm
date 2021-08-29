// [프로그래머스] 가운데 글자 가져오기
// https://programmers.co.kr/learn/courses/30/lessons/12903

package algorithm1;

public class Q7_12903 {
    public static String solution(String s) {
        String answer = "";
        char[] c = s.toCharArray();
        if (c.length % 2 != 0){
            int idx = c.length/2;
            answer = Character.toString(c[idx]);
        }
        else{
            int idx = c.length/2 - 1;
            answer = Character.toString(c[idx]) + Character.toString(c[idx+1]);
        }
        return answer;
    }
}
