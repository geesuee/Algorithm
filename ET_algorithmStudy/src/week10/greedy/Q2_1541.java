// [백준] 잃어버린 괄호
// https://www.acmicpc.net/problem/1541

package week10.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        int sum = Integer.MAX_VALUE;

        while(subtraction.hasMoreTokens()) {
            int tempSum = 0;
            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

            while(addition.hasMoreTokens()) {
                tempSum += Integer.parseInt(addition.nextToken());
            }

            if(sum == Integer.MAX_VALUE) {
                sum = tempSum;
            }else {
                sum -= tempSum;
            }
        }
        System.out.println(sum);
    }
}
