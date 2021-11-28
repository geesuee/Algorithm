// [백준] 2048 (Easy)
// https://www.acmicpc.net/problem/12100

package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_12100 {
    static int N;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, 0);
        System.out.println(answer);
    }

    static void dfs(int[][] curBoard, int cnt) {
        if(cnt == 5) {
            int max = findMax(curBoard);
            answer = Math.max(answer, max);
            return;
        }

        // 반복문 돌면서 상, 하, 좌, 우 로 보드 움직이고 dfs
        for(int i = 0; i < 4; i++) {
            int[][] nextBoard = moveBoard(curBoard, i);
            dfs(nextBoard, cnt+1);
        }
    }

    static int[][] moveBoard(int[][] curBoard, int direction) {
        // 보드 이동 (상, 하, 좌, 우)
            // 맨 처음 만나는 애들끼리 숫자 같으면 합체
            // 합체 됐으면 자리 조정 (nextBoard 갱신)

        // 상, 보드를 위로 움직일 때
            // 열을 기준으로 반복문(순방향)
                // 이전 숫자를 나타내는 변수 before(초기값은 0)
                // **비교 위치를 나타내는 변수 index(초기값은 0) 합치기가 일어나지 않을 경우, 그대로 ++
                // 해당 숫자가 0이 아니면
                    // 이전 숫자와 같으면 -> 합치고(0이면 0끼리 합쳐짐), 자리 조정, before 0으로 초기화
                    // 이전 숫자와 같지 않으면 -> 해당 숫자를 이전 숫자로 지정, **자리 조정, 넘어가니까 index++ 혹은 index--
                // 0이면 ...???
        // 하, 보드를 아래로 움직일 때
            // 열을 기준으로 반복문(역방향)
                // "
        // 좌, 보드를 왼쪽으로 움직일 때
            // 행을 기준으로 반복문(순방향)
                // "
        // 우, 보드를 오른쪽으로 움직일 때
            // 행을 기준으로 반복문(역방향)
                // "

        int[][] nextBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(curBoard[i], 0, nextBoard[i], 0, curBoard[i].length);
        }

        int before;
        int index;
        if(direction == 0) { // 상
            for(int i = 0; i < N; i++) {
                before = 0;
                index = 0;
                for(int j = 0; j < N; j++) {
                    if(nextBoard[j][i] != 0) {
                        if(nextBoard[j][i] == before) {
                            nextBoard[index - 1][i] = before * 2; // 위쪽으로 합침(index 바로 전 행으로)
                            before = 0;
                            nextBoard[j][i] = 0;
                        }else {
                            before = nextBoard[j][i];
                            // 자리 조정
                            nextBoard[j][i] = 0;
                            nextBoard[index][i] = before;
                            index++;
                        }
                    }
                }
            }
        } else if(direction == 1) { // 하
            for(int i = 0; i < N; i++) {
                before = 0;
                index = N-1;
                for(int j =N-1; j >= 0; j--) {
                    if(nextBoard[j][i] != 0) {
                        if(nextBoard[j][i] == before) {
                            nextBoard[index + 1][i] = before * 2; // 아래쪽으로 합침(index 바로 다음 행으로)
                            before = 0;
                            nextBoard[j][i] = 0;
                        }else {
                            before = nextBoard[j][i];
                            // 자리 조정
                            nextBoard[j][i] = 0;
                            nextBoard[index][i] = before;
                            index--;
                        }
                    }
                }
            }
        } else if(direction == 2) { // 좌
            for(int i = 0; i < N; i++) {
                before = 0;
                index = 0;
                for(int j = 0; j < N; j++) {
                    if(nextBoard[i][j] != 0) {
                        if(nextBoard[i][j] == before) {
                            nextBoard[i][index - 1] = before * 2;  // 왼쪽으로 합침(index 바로 전 열으로)
                            before = 0;
                            nextBoard[i][j] = 0;
                        }else {
                            before = nextBoard[i][j];
                            // 자리 조정
                            nextBoard[i][j] = 0;
                            nextBoard[i][index] = before;
                            index++; // 여기로 들어오면 index++ 이라 자리 그대로 유지 가능
                        }
                    }
                }
            }
        } else { // 우
            for(int i = 0; i < N; i++) {
                before = 0;
                index = N-1;
                for(int j = N-1; j >= 0; j--) {
                    if(nextBoard[i][j] != 0) {
                        if(nextBoard[i][j] == before) {
                            nextBoard[i][index + 1] = before * 2;  // 오른쪽으로 합침(index 바로 다음 열으로)
                            before = 0;
                            nextBoard[i][j] = 0;
                        }else {
                            before = nextBoard[i][j];
                            // 자리 조정
                            nextBoard[i][j] = 0;
                            nextBoard[i][index] = before;
                            index--;
                        }
                    }
                }
            }
        }

        return nextBoard;
    }

    static int findMax(int[][] curBoard) {
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, curBoard[i][j]);
            }
        }

        return max;
    }
}
