// [백준] 요세푸스 문제
// https://www.acmicpc.net/problem/1158

package week4.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1_1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList numbers = new LinkedList();
        for(int i = 0; i < n; i++) {
            numbers.add(i+1);
        }

        System.out.println(josephus(numbers, k));
    }

    static String josephus(LinkedList list, int x) {
        String str = "<";
        while(!list.isEmpty()) {
            for (int i = 0; i < x; i++) {
                if (i == x - 1) {
                    Object temp = list.remove();
                    if (list.size() == 0) {
                        str += temp;
                    } else {
                        str += temp + ", ";
                    }
                } else {
                    list.add(list.remove());
                }
            }
        }
        return str + ">";
    }
}
