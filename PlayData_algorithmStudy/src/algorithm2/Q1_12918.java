// [프로그래머스] 문자열 다루기 기본
// https://programmers.co.kr/learn/courses/30/lessons/12918

package algorithm2;

public class Q1_12918 {
    public static boolean solution(String s) {
        if(s.length() == 4 | s.length() == 6) {
            try{
                int num = Integer.parseInt(s);
                return true;
            }catch(Exception e) {
                return false;
            }
        }
        return false;
    }
}
