// [프로그래머스] 괄호 변환
// https://programmers.co.kr/learn/courses/30/lessons/60058
//* 미완

package week6.recursive;

public class Q3_60058 {

    public static void main(String[] args) {

    }

    public String solution(String p) {
        int left = 0;
        int right = 0;
        char[] arr = p.toCharArray();
        for(int i = 0; i < p.length(); i++) {
            if(arr[i] == '(') {
                left++;
            }else {
                right++;
            }
            if(left == right) {
                solution(p.substring(i+1, p.length()+1));
                break;
            }


        }

        if(left == right) {

        }

        String answer = "";
        return answer;
    }
}
