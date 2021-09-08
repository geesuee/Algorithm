// [프로그래머스] 괄호 변환
// https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
// 참고 코드 : https://velog.io/@jaeung5169/Programmers-%EA%B4%84%ED%98%B8-%EB%B3%80%ED%99%98

package week6.recursive;

import java.util.Stack;

public class Q3_60058 {
    public static void main(String[] args) {
		String p = "(()())()";
//      String p = ")(";
//		String p = "()))((()";

        System.out.println(solution(p));
    }

    public static String solution(String p) {
        String answer = "";

        /* 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. */
        if(p.isEmpty() || check(p)) {
            return p;
        }

        /* 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u와 v(나머지 문자열)로 분리합니다. */
        int sep = divide(p);
        String u = p.substring(0, sep);
        String v = p.substring(sep, p.length());

		/* 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  		   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. */
        if(check(u)) {
            answer = u + solution(v);
            /* 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. */
        }else {
			/* 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  			   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  			   4-3. ')'를 다시 붙입니다. */
            String s = "(" + solution(v) + ")";
			/* 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  			   4-5. 생성된 문자열을 반환합니다. */
            answer = s + replace(u.substring(1, u.length() - 1));
        }
        return answer;
    }


    //올바른 괄호 문자열인지 check하여 true반환하는 로직 - stack 이용
    public static boolean check(String p) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                stack.push('(');
            }else {
                if(stack.isEmpty()) {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    //p를 가장 작은 '균형 잡힌 괄호 문자열'인 u를 구하기 위해, 오른쪽 인덱스를 반환
    public static int divide(String p) {
        int leftCnt = 0;
        int rightCnt = 0;

        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                leftCnt++;
            }else {
                rightCnt++;
            }
            if(leftCnt == rightCnt) {
                break;
            }
        }
        return leftCnt + rightCnt;
    }

    //괄호 방향을 뒤집는 로직
    public static String replace(String u) {
        String r = "";
        for(int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') {
                r = r + ")";
            }else {
                r = r + "(";
            }
        }
        return r;
    }



}
