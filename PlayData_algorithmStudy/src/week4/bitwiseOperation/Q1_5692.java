// [백준] 팩토리얼 진법
// https://www.acmicpc.net/problem/5692

package week4.bitwiseOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_5692 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String number = br.readLine();
            if(number.equals("0")) break;

            int sum = 0;
            int len = number.length();
            for(char a : number.toCharArray()) {
                sum += (a - '0') * factorial(len--);
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
