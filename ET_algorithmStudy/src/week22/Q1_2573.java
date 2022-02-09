// [백준] 빙산
// https://www.acmicpc.net/problem/2573

package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1_2573 {
    static int N, M;
    static int[][] map;
    static int icebergCnt = 0;
    static int year = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Iceberg {
        int x;
        int y;

        public Iceberg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isOutOfMap(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while ((icebergCnt = countIceberg()) < 2) {
            if (icebergCnt == 0) {
                year = 0;
                break;
            }

            afterOneYear();
            year++;
        }

        System.out.println(year);
    }

    public static int countIceberg() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // 빙하 개수를 세는 DFS
    public static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isOutOfMap(nx, ny)) {
                continue;
            }

            if (map[nx][ny] != 0 && !visited[nx][ny]) {
                DFS(nx, ny, visited);
            }
        }
    }

    // 빙하가 얼마나 녹았는지 확인하는 BFS
    public static void afterOneYear() {
        Queue<Iceberg> q = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new Iceberg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Iceberg ice = q.poll();

            int seaNum = 0;

            for (int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if (isOutOfMap(nx, ny)) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    seaNum++;
                }
            }

            if (map[ice.x][ice.y] - seaNum < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= seaNum;
            }
        }
    }
}
