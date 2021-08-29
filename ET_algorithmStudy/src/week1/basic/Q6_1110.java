// [백준] 더하기 사이클
// https://www.acmicpc.net/problem/1110

package week1.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int num = N;
        int count = 0;

        while(true) {
            int a = num / 10;
            int b = num % 10;

            num = (b * 10) + ((a + b) % 10);
            count++;

            if(num == N) {
                break;
            }
        }
        System.out.println(count);
    }
}
