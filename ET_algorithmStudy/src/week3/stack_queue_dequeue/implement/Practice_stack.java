// stack 라이브러리 활용

package week3.stack_queue_dequeue.implement;

import java.util.Stack;

public class Practice_stack {

    public static void main(String[] args) {
        Stack<Character> cs = new Stack<>();

        cs.push('A');
        cs.push('B');
        cs.push('C');

        System.out.println(cs.peek());  // C
        System.out.println(cs.size());  // 3

        cs.pop();

        System.out.println(cs.size());  // 2

        for (char A:cs) {
            System.out.println(A);
        }
        System.out.println("=========");
        for (int i = 0; i < cs.size(); i++) {
            System.out.println(cs.elementAt(i));
        }
    }
}
