// [백준] 로봇 청소기
// https://www.acmicpc.net/problem/14503

package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_14503 {
    static int N, M;
    static int[][] map;
    static int cnt = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean isOutOfMap(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanMap(r, c, d);

        System.out.println(cnt);
    }

    public static void cleanMap(int r, int c, int d) {

        if (map[r][c] == 0) {
            map[r][c] = 2;
            cnt++;
        }

        boolean flag = false;
        int origin = d;
        for (int i = 0; i < 4; i++) {
            int nd = (d+3) % 4;
            int nx = r + dx[nd];
            int ny = c + dy[nd];

            if (!isOutOfMap(nx, ny)) {
                if (map[nx][ny] == 0) {
                    cleanMap(nx, ny, nd);
                    flag = true;
                    break;
                }
            }
            d = (d + 3) % 4;
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        if (!flag) {
            int nd = (origin+2) % 4;
            int n_bx = r + dx[nd];
            int n_by = c + dy[nd];

            if (!isOutOfMap(n_bx, n_by)) {
                if (map[n_bx][n_by] != 1) {
                    cleanMap(n_bx, n_by, origin);
                }
            }
        }
    }
}
