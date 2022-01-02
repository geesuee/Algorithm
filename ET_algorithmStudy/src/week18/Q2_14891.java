// [백준] 14891 톱니바퀴
// https://www.acmicpc.net/problem/14891

package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_14891 {
    static int[][] wheels = new int[4][8];
    static int K;              // 회전 횟수
    static int[] directions;   // 회전하는 방향

    // N극은 0, S극은 1
    // 마지막 톱니바퀴 제외, index 2 가 다음 톱니바퀴의 index 6 과 맞닿음

    // 맞닿은 극이 같다면 -> 회전하지 않음
    // 맞닿은 극이 다르다면 -> **반대방향으로 회전함

    // 방향이 1인 경우 시계방향, 방향이 -1인 경우 반시계방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = Integer.parseInt(input[j]);
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            directions = new int[4];
            st = new StringTokenizer(br.readLine());
            setDirections(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            moveWheels(directions);
        }

        System.out.println(sumWheelScore());
    }

    static void setDirections(int wheelNum, int dir) {
        directions[wheelNum] = dir;

        int prev = wheelNum - 1;
        int next = wheelNum + 1;

        // 왼쪽 바퀴들 확인
        if (prev >= 0 && directions[prev] == 0) {
            if (wheels[prev][2] != wheels[wheelNum][6]) {
                setDirections(prev, dir * -1);
            }
        }

        // 오른쪽 바퀴들 확인
        if (next <= 3 && directions[next] == 0) {
            if (wheels[wheelNum][2] != wheels[next][6]) {
                setDirections(next, dir * -1);
            }
        }

    }

    static void moveWheels(int[] directions) {
        for (int i = 0; i < 4; i++) {
            if (directions[i] != 0) {
                int[] temp = new int[8];
                int idx;

                for (int j = 0; j < 8; j++) {
                    idx = j + directions[i];

                    if (idx == -1) {
                        idx = 7;
                    } else if (idx == 8) {
                        idx = 0;
                    }

                    temp[idx] = wheels[i][j];
                }

                wheels[i] = temp;
            }
        }
    }

    static int sumWheelScore() {
        int total = 0;

        for (int i = 0; i < 4; i++) {
            int num = wheels[i][0];

            if (num == 1) {
                total += Math.pow(2, i);
            }
        }

        return total;
    }
}
