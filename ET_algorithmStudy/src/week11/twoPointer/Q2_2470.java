// [백준] 두 용액
// https://www.acmicpc.net/problem/2470

package week11.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //twoPointer
        int p1 = 0;
        int p2 = N-1;
        int fit = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);

        while(p1 < p2) {
            int sum = arr[p1] + arr[p2];

            if(Math.abs(sum) < fit) {
                fit = Math.abs(sum);
                sb = new StringBuilder();
                sb.append(arr[p1] + " ");
                sb.append(arr[p2]);
            }if(sum > 0) {
                p2--;
            }else {
                p1++;
            }
        }

        System.out.println(sb.toString());
    }
}
