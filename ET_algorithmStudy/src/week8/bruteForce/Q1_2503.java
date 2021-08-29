// [백준] 숫자 야구
// https://www.acmicpc.net/problem/2503

package week8.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1_2503 {
    static int N;
    static List<BaseBallData> inputData = new ArrayList<>();

    static class BaseBallData {
        int data;
        int strike;
        int ball;

        public BaseBallData(int data, int strike, int ball) {
            this.data = data;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st  = new StringTokenizer(br.readLine(), " ");
            int data = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            BaseBallData baseBallData = new BaseBallData(data, strike, ball);
            inputData.add(baseBallData);
        }

        System.out.println(numberBaseBall());
    }

    static int numberBaseBall() {
        int passCase = 0;

        for(int i = 123; i <= 987; i++) {
            if(!checkNum(i)) continue;  //숫자 조건에 안맞으면 넘어가기

            int testPass = 0;

            for(int j = 0; j < N; j++) {
                int strikeCnt = 0;
                int ballCnt = 0;

                BaseBallData current = inputData.get(j);
                String currentData = Integer.toString(current.data);
                String testData = Integer.toString(i);

                //strike & ball
                for(int k = 0; k < 3; k++) {
                    if (currentData.charAt(k) == testData.charAt(k)) {
                        strikeCnt++;
                    }

                    for(int h = 0; h < 3; h++) {
                        if(testData.charAt(k) == currentData.charAt(h) && k != h) {
                            ballCnt++;
                        }
                    }
                }

                if(current.strike == strikeCnt && current.ball == ballCnt) {
                    testPass++;
                }
            }
            if(testPass == N) {
                passCase++;
            }
        }
        return passCase;
    }

    static boolean checkNum(int number) {
        String sNumber = Integer.toString(number);

        if(sNumber.charAt(0) == sNumber.charAt(1)) {
            return false;
        }
        if(sNumber.charAt(1) == sNumber.charAt(2)) {
            return false;
        }
        if(sNumber.charAt(0) == sNumber.charAt(2)) {
            return false;
        }
        if(sNumber.charAt(0) == '0' || sNumber.charAt(1) == '0' || sNumber.charAt(2) == '0') {
            return false;
        }

        return true;
    }
}
