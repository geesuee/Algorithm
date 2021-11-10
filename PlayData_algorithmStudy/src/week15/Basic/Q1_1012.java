// [백준] 유기농 배추
// https://www.acmicpc.net/problem/1012

package week15.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1_1012 {
    static int M, N, K;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for(int i = 0; i < T; i++) { // 테스트 케이스 반복
            int larva = 0;

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

            arr = new int[M][N];
            visit = new boolean[M][N];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
            }

            // 핵심 로직 실행
            for (int k = 0; k < M; k++) {
                for (int l = 0; l < N; l++) {
                    if (arr[k][l] == 1 && !visit[k][l]) {
                        bfs(k, l);
                        larva++;
                    }
                }
            }

            sb.append(larva).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void bfs(int x, int y) {
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] { x, y });

        while (!qu.isEmpty()) {
            x = qu.peek()[0];
            y = qu.peek()[1];
            visit[x][y] = true;
            qu.poll();
            for (int i = 0; i < 4; i++) { // 오,아래,왼,위
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < M && cy < N) { // 밭 범위 안에 있으면서
                    if (!visit[cx][cy] && arr[cx][cy] == 1) { // 방문하지 않았고, 배추가 있으면
                        visit[cx][cy] = true;
                        qu.add(new int[] { cx, cy });
                    }
                }

            }

        }
    }
}
