// [백준] 나이트의 이동
// https://www.acmicpc.net/problem/7562

package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2_7562 {
    static int T; // 테스트 케이스 개수
    static int N; // 체스판 한 변의 길이
    static int currentX, currentY; // 나이트가 현재 있는 칸
    static int finalX, finalY; // 나이트가 이동하려고 하는 칸

    // 왼쪽 위부터 시계 방향으로 이동
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static boolean isOutOfBoard(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            String[] current = br.readLine().split(" ");
            currentX = Integer.parseInt(current[0]);
            currentY = Integer.parseInt(current[1]);

            String[] next = br.readLine().split(" ");
            finalX = Integer.parseInt(next[0]);
            finalY = Integer.parseInt(next[1]);

            sb.append(countMovement()).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static int countMovement() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.add(new Node(currentX, currentY, 0));
        visited[currentX][currentY] = true;

        while (!q.isEmpty()) {
            Node knight = q.poll();

            if (knight.x == finalX && knight.y == finalY) {
                return knight.dist;
            }

            for (int i = 0; i < 8; i++) {
                int newX = knight.x + dx[i];
                int newY = knight.y + dy[i];

                if (isOutOfBoard(newX, newY) || visited[newX][newY]) {
                    continue;
                }

                q.add(new Node(newX, newY, knight.dist+1));
                visited[newX][newY] = true;
            }
        }

        return 0;
    }
}
