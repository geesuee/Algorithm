// [백준] 청소년 상어
// https://www.acmicpc.net/problem/19236
// 참고 : https://minhamina.tistory.com/67
// 실패..

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_19236 {
    static int[][] map;
    static Fish[] fish;
    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer;

    static class Fish {
        int x;
        int y;
        int num;
        int dir;
        boolean eaten; // 먹혔으면 true, 아직 살아있으면 false

        public Fish(int x, int y, int num, int dir, boolean eaten) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.eaten = eaten;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fish = new Fish[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;
                fish[num] = new Fish(i, j, num, dir, false);
                map[i][j] = num;
            }
        }

        int currentX = 0;
        int currentY = 0;
        int currentDir = fish[map[0][0]].dir;
        int eat = map[0][0];

        fish[map[0][0]].eaten = true;
        map[0][0] = -1;

        dfs(currentX, currentY, currentDir, eat);

        System.out.println(answer);
    }

    static void dfs(int currentX, int currentY, int currentDir, int eat) {
        answer = Math.max(answer, eat);
        // 이전에 먹었던 물고기 번호 합 max 비교하여 answer에 저장

        // map 배열 복사
        int[][] tempMap = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
        }

        // fish 배열 복사
        Fish[] tempFish = new Fish[fish.length];
        for (int i = 1; i <= 16; i++) {
            tempFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].num, fish[i].dir, fish[i].eaten);
        }

        moveFish();

        for (int i = 1; i < 4; i++) { // 4*4 행렬로 1칸, 2칸, 3칸까지 최대로 이동 가능
            int nx = currentX + dx[currentDir] * i;
            int ny = currentY + dy[currentDir] * i;

            // map 을 벗어나지 않고, 물고기가 없는 빈칸이 아닐 경우
            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
                int eatFish = map[nx][ny];
                currentDir = fish[eatFish].dir;
                map[currentX][currentY] = 0;
                map[nx][ny] = -1;
                fish[eatFish].eaten = true;

                dfs(currentX, currentY, currentDir, eat + eatFish);

                // 물고기 상태, 상어 위치 원래대로
                fish[eatFish].eaten = false;
                map[currentX][currentY] = -1;
                map[nx][ny] = eatFish;
            }
        }

        // map 상태, 물고기 정보 되돌리기
        for (int j = 0; j < map.length; j++) {
            System.arraycopy(tempMap[j], 0, map[j], 0, map.length);
        }
        for (int i = 1; i <= 16; i++) {
            fish[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].num, tempFish[i].dir, tempFish[i].eaten);
        }
    }

    // 물고기 이동
    static void moveFish() {
        for (int i = 1; i <= 16; i++) {
            if (fish[i].eaten == true) {
                continue;
            }
            int cnt = 0;
            int dir = fish[i].dir;
            int nx = 0;
            int ny = 0;

            while (cnt < 8) { // 이동할 수 있는 위치를 찾을 때까지 45도 방향 바꾸며 반복
                dir %= 8;
                fish[i].dir = dir;
                nx = fish[i].x + dx[dir];
                ny = fish[i].y + dy[dir];

                // 이동할 위치가 map 을 벗어나지 않고, 상어가 없다면 이동 가능
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) {

                    // 이동할 위치가 빈칸인 경우
                    if (map[nx][ny] == 0) {
                        map[fish[i].x][fish[i].y] = 0;
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    } else { // 이동할 위치에 다른 물고기가 있을 경우
                        // 바꿀 물고기 위치 변경
                        int changeFish = fish[map[nx][ny]].num;
                        fish[changeFish].x = fish[i].x;
                        fish[changeFish].y = fish[i].y;
                        map[fish[changeFish].x][fish[changeFish].y] = changeFish;

                        // 현재 물고기 위치 변경
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    }
                    break;
                } else {
                    dir++;
                    cnt++;
                }
            }
        }
    }
}
