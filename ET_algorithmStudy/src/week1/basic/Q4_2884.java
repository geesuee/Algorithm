// [백준] 알람 시계
// https://www.acmicpc.net/problem/2884

package week1.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] s1 = s.split(" ");

        int H = Integer.parseInt(s1[0]);
        int M = Integer.parseInt(s1[1]);
        br.close();

        if(M >= 45) {
            M -= 45;
        }
        else {
            if(H == 0) {
                H = 23;
            }
            else {
                H -= 1;
            }
            M = 60 - (45 - M);
        }
        System.out.println(H+" "+M);
    }
}
