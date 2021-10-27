// [백준] 태권왕
// https://www.acmicpc.net/problem/14562

package week13.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    boolean success;
    int S;
    int T;
    Node left;
    Node right;

    public Node(int S, int T) {
        this.S = S;
        this.T = T;
        this.left = null;
        this.right = null;
        success = false;
    }
}

class Q2_14562_trial {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());
        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            cnt = 0;

        }
    }
}
