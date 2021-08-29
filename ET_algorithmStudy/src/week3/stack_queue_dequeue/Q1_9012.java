// [백준] 괄호
// https://www.acmicpc.net/problem/9012

package week3.stack_queue_dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(check(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String check(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { stack.push(c);}
            else if (stack.empty()) { return "NO"; }
            else { stack.pop(); }
        }

        if (stack.empty()) { return "YES"; }
        else { return "NO"; }
    }
}
