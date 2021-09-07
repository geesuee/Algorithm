// [프로그래머스] 괄호 변환
// https://programmers.co.kr/learn/courses/30/lessons/60058
//* 미완

package week6.recursive;

import java.util.Stack;

public class Q3_60058_stack {

    public static void main(String[] args) {
        System.out.println(solution("()())"));
    }

    public static String solution(String p) {
        Stack<Character> stack = new Stack<>();
        char[] arr = p.toCharArray();

        for(int i = 0; i < p.length(); i++) {
            try {
                if(arr[i] == '(') {
                    stack.push(arr[i]);
                }else {
                    stack.pop();
                }
                if(i >= 1 && stack.isEmpty()) {
                    solution(p.substring(i, p.length()+1));
                }
            }catch(Exception e) {
                System.out.println(i);
            }
        }

        String answer = "";
        return answer;
    }
}
