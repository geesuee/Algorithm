// [백준] 가로수
// https://www.acmicpc.net/problem/2485

package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tree = new int[N];
        int[] distance = new int[N-1];
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
            if(i != 0) {
                distance[i-1] = tree[i] - tree[i-1];
            }
        }
        // System.out.println(" tree : " + Arrays.toString(tree));
        // System.out.println("check : " + Arrays.toString(check));
        // System.out.println(" distance : " + Arrays.toString(distance));

        int[] gcdList = new int[N-2];
        for(int j = 0; j < N-2; j++) {
            gcdList[j] = gcd(distance[j], distance[j+1]);
            if(j != 0) {
                gcdList[j] = gcd(gcdList[j-1], gcdList[j]);
            }
        }
        int gcd = gcdList[gcdList.length - 1];
        //System.out.println(" gcdList : " + Arrays.toString(gcdList));
        // System.out.println(" gcd : " + gcd);

        // 전체 간격을 최대공약수로 나누고, 심어진 나무 개수 제외
        System.out.println((tree[N-1] - tree[0]) / gcd - (N-1));
    }

    // 최대공약수 - 유클리드 호제법
    static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
