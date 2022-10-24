// [백준] 개똥벌레
// https://www.acmicpc.net/problem/3020

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1_3020_try3 {
    static int N;
    static ArrayList<Integer> up;   // 종유석
    static ArrayList<Integer> down; // 석순

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 길이
        int H = Integer.parseInt(st.nextToken()); // 높이

        up = new ArrayList<>();
        down = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (i % 2 != 0) { // 홀수 => 석순(down)
                down.add(Integer.parseInt(br.readLine()));
            } else { // 짝수 => 종유석(up)
                up.add(Integer.parseInt(br.readLine()));
            }
        }

        int mid = H/2;
        int count = checkObstacles(mid);

        // up 을 확인하기 위한 반복문
        int sameCount1 = 0;
        for (int i = 0; i < up.size(); i++) {
            int checkPoint = mid-i;
            int temp = checkObstacles(checkPoint);
            System.out.println("**up " + temp);
            if (temp == count) {
                sameCount1++;
            } else {
                break;
            }
        }

        // down 을 확인하기 위한 반복문
        int sameCount2 = 0;
        for (int i = 0; i < down.size(); i++) {
            int checkPoint = mid+i;
            int temp = checkObstacles(checkPoint);
            System.out.println("**down " + temp);
            if (temp == count) {
                sameCount2++;
            } else {
                break;
            }
        }

        int totalSameCount = sameCount1 + sameCount2;

        System.out.println(count + " " + totalSameCount);
    }

    static int checkObstacles(int checkPoint) {
        int count = 0;
        for (int i = 0; i < N/2; i++) {
            if (up.get(i) + 1 >= checkPoint && down.get(i) + 1 >= checkPoint) {
                count += 1;
            }
            else if (down.get(i)+1 >= checkPoint) {
                count += 1;
            }
            else if (up.get(i)+1 >= checkPoint) {
                count += 1;
            }
        }
        return count;
    }
}
