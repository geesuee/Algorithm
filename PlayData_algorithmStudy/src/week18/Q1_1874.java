// [백준] 스택 수열
// https://www.acmicpc.net/problem/1874

package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int count = 1;
        for(int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            while(count <= number) {
                stack.push(count++);
                sb.append("+\n");
            }
            if(stack.peek() == number) {
              stack.pop();
                sb.append("-\n");
            }else {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb.toString());
    }
}
