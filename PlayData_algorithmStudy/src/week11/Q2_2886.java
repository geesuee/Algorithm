// [백준] 자리 전쟁
// https://www.acmicpc.net/problem/2886
// 미완

package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2_2886 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(R + " " + C);

        int[][] people = new int[R][C];
        int[][] seats = new int[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            char[] cArr = s.toCharArray();
            for(int j = 0; j < C; j++) {
                System.out.println(cArr[j]);
                if(cArr[j] == 'X') { // 사람
                    people[i][j] = 1;
                }else if(cArr[j] == 'L') { // 좌석
                    seats[i][j] = 1;
                }
            }

//            char[] arr = s.toCharArray();
//            for(int j = 0; j < C; j++) {
//                if(arr[j] == 'X') { // 사람
//                    people[i][j] = 1;
//                }else if(arr[j] == 'L') { // 좌석
//                    seats[i][j] = 1;
//                }
//            }
        }

        System.out.println("***");
        System.out.println(solution(people, seats));
    }

    public static int solution(int[][] people, int[][] seats) {
        int answer = 0;

        for(int[] s : seats) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int rival = 0;
            for(int[] p : people) {
                int dist = (s[0]-p[0])^2 + (s[1]-p[1])^2;
                pq.add(dist);
            }

            int min1 = pq.poll();
            int min2 = pq.poll();
            if(min1 == min2) {
                answer++;
                //앉은 사람을 빼줘야함..ㅜ
            }
        }

        return answer;
    }
}
