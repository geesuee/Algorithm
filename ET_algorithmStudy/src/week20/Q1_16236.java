// [백준] 아기상어
// https://www.acmicpc.net/problem/16236
// 참고 : https://devje8.tistory.com/11

package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1_16236 {
    static int N;           // 공간의 한 변 크기
    static int[][] space;   // 공간
    static int babyShark = 2;   // 아기 상어의 크기 (초기 크기는 2)
    static ArrayList<Info> eatableFishes;
    static int fishCounts;  // 아기 상어가 먹은 물고기의 수 (자신의 크기만큼 물고기를 먹으면 크기++, 초기화 됨!!)
    static int seconds;     // 소요 시간

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int currentX;    // 현재 상어의 위치 X
    static int currentY;    // 현재 상어의 위치 Y

    static class Info {
        int x;
        int y;
        int dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // space 범위 안에 있지 않다면 true 반환
    static boolean isOutOfSpace(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                space[i][j] = num;
                if (num == 9) {
                    currentX = i;
                    currentY = j;
                    space[i][j] = 0; //**상어가 있는 위치 값 저장 후, 해당 위치 0 으로 초기화
                }
            }
        }

        while (true) {
            findEatableFishes();

            // 먹을 수 있는 물고기 리스트가 0인 경우 = 종료 조건
            if (eatableFishes.size() == 0) {
                System.out.println(seconds);
                return;
            }

            // 먹을 수 있는 물고기가 있는 경우, 물고기 섭취
            eatFish();
        }
    }

    // 먹을 수 있는 물고기가 있는지 찾는 bfs
    static void findEatableFishes() {
        eatableFishes = new ArrayList<>();
        Queue<Info> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        // 상어의 현재 위치 큐에 삽입
        queue.offer(new Info(currentX, currentY, 0));
        visited[currentX][currentY] = true;

        while (!queue.isEmpty()) {
            Info shark = queue.poll();

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int newX = shark.x + dx[i];
                int newY = shark.y + dy[i];

                // 범위에서 벗어나거나 이미 방문한 공간인 경우
                if (isOutOfSpace(newX, newY) || visited[newX][newY]) {
                    continue;
                }

                // 먹을 수 있는 물고기를 찾은 경우
                // 물고기를 먹고 지나갈 수 있는 곳이므로 큐에 추가하고 방문 표시
                // 먹을 수 있는 물고기 리스트에도 추가
                if (1 <= space[newX][newY] && space[newX][newY] < babyShark) {
                    queue.offer(new Info(newX, newY, shark.dist + 1));
                    eatableFishes.add(new Info(newX, newY, shark.dist + 1));
                    visited[newX][newY] = true;
                }
                // 먹을 수는 없지만, 지나갈 수 있는 경우 (0 이거나 상어의 사이즈와 같은 경우)
                // 물고기를 먹을 수는 없지만 지나갈 수 있는 곳이므로 큐에 추가하고 방문 표시
                else if (space[newX][newY] == 0 || space[newX][newY] == babyShark) {
                    queue.offer(new Info(newX, newY, shark.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }

    }

    // 먹을 수 있는 물고기 중 가장 가까운 물고기 섭취
    static void eatFish() {
        // 먹을 수 있는 물고기가 있는 경우, 가장 가까운 물고기부터 꺼냄
        Info nearestFish = eatableFishes.get(0); // 임의로 설정 후 갱신
        for (int i = 1; i < eatableFishes.size(); i++) {
            if (eatableFishes.get(i).dist < nearestFish.dist) {
                nearestFish = eatableFishes.get(i);
            }
            else if (eatableFishes.get(i).dist == nearestFish.dist) { // 거리가 같을 경우
                if (eatableFishes.get(i).x < nearestFish.x) {
                    nearestFish = eatableFishes.get(i);
                }
                else if (eatableFishes.get(i).x == nearestFish.x) { // 거리도 같고, x 좌표도 같을 경우
                    if (eatableFishes.get(i).y < nearestFish.y) {
                        nearestFish = eatableFishes.get(i);
                    }
                }
            }
        }

        // 물고기 섭취 => 거리만큼 시간 소요, 먹은 물고기 수 증가, 물고기가 있던 자리 0으로 초기화
        seconds += nearestFish.dist;
        fishCounts++;
        space[nearestFish.x][nearestFish.y] = 0;

        // 자기 몸 사이즈만큼 물고기 먹으면 사이즈++, 카운트는 초기화
        if (fishCounts == babyShark) {
            babyShark++;
            fishCounts = 0;
        }

        // 상어 위치 갱신
        currentX = nearestFish.x;
        currentY = nearestFish.y;
    }
}
