// [백준] 로또
// https://www.acmicpc.net/problem/6603

package week2.string_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_6603 {

    public static int k;
    public static int[] s;
    public static int[] lotto = new int[6];

    public static void choose(int count, int idx) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(lotto[i]+" ");
            }
            System.out.println();
            return;
        }

        // 앞자리가 결정되면 그 뒷자리 애들만 가지고 뒷자리 결정
        for (int i = idx; i < k; i++){
            lotto[count] = s[i];
            choose(count+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);

            // 마지막에 0이 들어오면 반복문 탈출
            if (k == 0) {
                break;
            }

            // 그 외의 경우, 길이 k인 배열 s 생성
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(input[i+1]);
            }

            choose(0,0);
            System.out.println();
        }
    }
}
