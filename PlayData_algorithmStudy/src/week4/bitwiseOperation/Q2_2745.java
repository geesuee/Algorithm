// [백준] 진법 변환
// https://www.acmicpc.net/problem/2745

package week4.bitwiseOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;
        int len = N.length() - 1;

        for(char c : N.toCharArray()) {
            if(c >= '0' && c <= '9') {
                sum += (c - '0') * Math.pow(B, len--);
            }else {
                sum += ((int)c - 55) * Math.pow(B, len--);
            }
        }
        System.out.println(sum);
    }
}
