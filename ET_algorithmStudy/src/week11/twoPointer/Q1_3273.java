// [백준] 두 수의 합
// https://www.acmicpc.net/problem/3273

package week11.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1_3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        //twoPointer
        int start = 0;
        int end = n-1;
        int count = 0;

        Arrays.sort(arr);

        while(start != end) {
            if(arr[start] + arr[end] == x) {
                count++;
                //System.out.println(arr[start] + " " + arr[end] + " = " + (arr[start]+arr[end]));
            }if(arr[start] + arr[end] > x) {
                end--;
            }else {
                start++;
            }
        }
        System.out.println(count);
    }
}
