// [백준] 좌표 정렬하기
// https://www.acmicpc.net/problem/11650

package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Q4_11650 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Node> nodeList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            nodeList.add(new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        nodeList.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        nodeList.forEach(System.out::println);
    }
}
