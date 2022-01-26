// [백준] 적록색약
// https://www.acmicpc.net/problem/10026

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_10026 {
    static int N;
    static char[][] color;
    static boolean[][] visited;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        color = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            color[i] = br.readLine().toCharArray();
        }

        int ans1 = 0; // 적록색약이 아닌 사람의 구역 수
        int ans2 = 0; // 적록색약인 사람의 구역 수

        // 적록색약이 아닌 사람 관점
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    ans1++;
                }
            }
        }

        // 적록색약인 사람 관점
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (color[i][j] == 'G') {
                    color[i][j] = 'R';
                }
            }
        }
        visited = new boolean[N+1][N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        char nowColor = color[x][y];

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                if (!visited[newX][newY] && color[newX][newY] == nowColor) {
                    dfs(newX, newY);
                }
            }
        }
    }
}
