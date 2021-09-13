// [백준] 계단 오르기
// https://www.acmicpc.net/problem/2579

package week7.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        //계단 수와 index 맞춰주기 위해 + 1
        int[] DP = new int[total + 1];
        int[] stair = new int[total + 1];

        //계단 수와 index 맞춰주기 위해 1부터 시작 ~ total+1까지
        for(int i = 1; i < total+1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        //총 계단 수가 1개면, 최대 점수 = 첫번째 계단이자 마지막 계단을 밟아 얻은 점수
        DP[1] = stair[1];

        //총 계단 수가 2개면, 최대 점수 = 첫번째 계단, 두번째 계단을 모두 밟아 얻은 점수
        if(total >= 2) {
            DP[2] = stair[1] + stair[2];
        }

        //계단 수가 3개가 되는 시점부터,
        //n-3 / n-2 / n-1 / n
        //현재 차례의(n번째) 계단을 밟는다는 가정하에
        //n-3, n-2,     ,n 이렇게 밟을지 - 보다 정확하게는 바로 전 것을 안 밟을지 (DP[n-2]는 n-2번째까지 최대 점수이기 때문에 꼭 n-3을 밟았을 것이라고 볼 수 없음)
        //n-3,    , n-1, n 이렇게 밟을지 - 보다 정확하게는 전전 것을 안 밟을지
        //더 큰 값 선택하고, 현재 차례 계단 점수 더해줌
        for(int n = 3; n <= total; n++) {
            DP[n] = Math.max(DP[n-2], DP[n-3]+stair[n-1]) + stair[n];
        }

        System.out.println(DP[total]);
    }
}
