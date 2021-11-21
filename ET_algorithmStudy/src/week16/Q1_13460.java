// [백준] 구슬 탈출 2
// https://www.acmicpc.net/problem/13460
// 출처 : https://minhamina.tistory.com/191

package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Marble {
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    Marble(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}

public class Q1_13460 {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited; // 왜 4차원까지 가야할까? -> 빨간 구슬 x, y, 파란 구슬 x, y 방문 이력을 함께 표시하기 위해
    static int holeX, holeY; // 구멍의 위치
    static Marble red, blue; // 빨간 구슬, 파란 구슬 좌표와 이동 횟수 포함한 Marble

    // x : 행, y : 열 (좌표상 x,y와 반대로 생각)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 상, 우, 하, 좌 (시계 방향)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  //세로
        M = Integer.parseInt(st.nextToken());  //가로

        board = new char[N][M];
        visited = new boolean[N][M][N][M];  // 왜.... -> rx, ry, bx, by 최댓값 사이즈


        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                if(board[i][j] == 'O') {  // 구멍
                    holeX = i;
                    holeY = j;
                } else if(board[i][j] == 'B') {  // 파란 구슬
                    blue = new Marble(0, 0, i, j, 0);
                } else if(board[i][j] == 'R') {  // 빨간 구슬
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }
        // System.out.println(Arrays.deepToString(board));
        System.out.println(bfs());
        br.close();
    }

    static int bfs() { // Marble을 bfs로 돌아서 최단거리 탐색
        Queue<Marble> queue = new LinkedList<>();
        // 현재 빨간 구슬의 좌표, 파란 구슬의 좌표, 이동 횟수
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        // 현재 빨간 구슬의 위치에 빨간 구슬이 지나갔다는 것과
        // 현재 파란 구슬의 위치에 파란 구슬이 지나갔다는 것 표시
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while(!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if(curCnt > 10) {  // 10번 이하로 뺄 수 없다면 -1 출력
                return -1;
            }

            // 구슬 이동
            for(int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 빨간 구슬 이동 ('#' 벽을 만날 때까지 **한 방향**으로 쭉)
                while(board[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    // 이동 중 구멍을 만날 경우
                    if(newRx == holeX && newRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }

                // 파란 구슬 이동 ('#' 벽을 만날 때까지 **한 방향**으로 쭉)
                while(board[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    // 이동 중 구멍을 만날 경우
                    if(newBx == holeX && newBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                // 이동은 이동대로 일단 따로하고 아래에서 케이스 체크
                // 1. 파란 구슬이 탈출했을 경우
                // 2. 빨간 구슬만 탈출했을 경우(이어서 파란 구슬도 탈출해버리면 안됨)
                // 3. 둘 다 탈출 실패
                    // 3-1. 같은 위치로 이동해야하는 경우 -> x, y 값 비교해서 앞,뒤 위치 조정 필요
                    // 3-2. 두 구슬이 이동한 위치가 처음 방문한 위치인 경우 -> 큐에 추가

                if(isBlueHole) {
                    continue; // **실패지만, 큐에 남은 다른 좌표도 봐야하기 때문에 넘어감**
                }
                if(isRedHole && !isBlueHole) {
                    return curCnt;
                }
                else {
                    // 같은 위치로 이동 -> 위치 조정
                    if(newRx == newBx && newRy == newBy) {
                        // dx, dy 이동 방식(시계 방향 이동)으로 케이스 나눠 처리
                        if(i == 0) { // 상
                            // 더 큰 x 값(행 위치)을 가지는 구슬이 뒤로 감
                            if(curRx > curBx) {
                                newRx -= dx[i];
                            } else {
                                newBx -= dx[i];
                            }
                        } else if(i == 1) { // 우
                            // 더 작은 y 값(열 위치)을 가지는 구슬이 뒤로 감
                            if(curRy < curBy) {
                                newRy -= dy[i];
                            } else {
                                newBy -= dy[i];
                            }
                        } else if(i == 2) { // 하
                            // 더 작은 x 값(행 위치)을 가지는 구슬이 뒤로 감
                            if(curRx < curBx) {
                                newRx -= dx[i];
                            } else {
                                newBx -= dx[i];
                            }
                        } else { //좌
                            // 더 큰 y 값(열 위치)을 가지는 구슬이 뒤로 감
                            if(curRy > curBy) {
                                newRy -= dy[i];
                            } else {
                                newBy -= dy[i];
                            }
                        }
                    }

                    // 처음 방문하는 곳으로 이동 -> 큐에 추가
                    if(!visited[newRx][newRy][newBx][newBy]) {
                        visited[newRx][newRy][newBx][newBy] = true;
                        queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt+1));
                    }
                }
            }
        }

        return -1;
    }
}
