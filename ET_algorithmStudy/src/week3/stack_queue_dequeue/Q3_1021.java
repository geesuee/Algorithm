// [백준] 회전하는 큐
// https://www.acmicpc.net/problem/1021

package week3.stack_queue_dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q3_1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = deque.indexOf(target);

            // 2번
            if(targetIdx <= deque.size()/2) {
                for (int j = 0; j < targetIdx; j++) {
                    int temp = deque.pop();
                    deque.add(temp);
                    count++;
                }
            }
            // 3번
            else {
                for (int j = 0; j < deque.size()-targetIdx; j++) {
                    int temp = deque.pollLast();
                    deque.push(temp);
                    count++;
                }
            }
            deque.pop();
        }
        System.out.println(count);
    }
}
