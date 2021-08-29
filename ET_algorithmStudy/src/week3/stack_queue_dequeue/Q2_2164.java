// [백준] 카드2
// https://www.acmicpc.net/problem/2164

package week3.stack_queue_dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        System.out.println(card(queue));
    }
    public static int card(Queue<Integer> queue) {
        int size = queue.size();
        for(int i = 0; i < size-1 ; i++) {
            queue.poll();
            int num = queue.poll();
            queue.add(num);
        }
        return queue.peek();
    }
}
