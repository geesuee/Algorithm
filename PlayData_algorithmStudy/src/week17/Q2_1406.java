// [백준] 에디터
// https://www.acmicpc.net/problem/1406

package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i));
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if(c == 'L') {
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
            }else if(c == 'D') {
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
            }else if(c == 'B') {
                if(!left.isEmpty()) {
                    left.pop();
                }
            }else { // P
                left.push(command.charAt(2));
            }
        }

        // 오른쪽으로 다 이동시켜서 순서 맞춰줌
        while(!left.isEmpty()) {
            right.push(left.pop());
        }

        while(!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb.toString());
    }
}
