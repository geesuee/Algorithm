// [백준] 자리 전쟁
// https://www.acmicpc.net/problem/2886
// 실패...왜..?

package week13.Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2_2886 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[][] people = new boolean[R][C];
        boolean[][] seats = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            char[] cArr = s.toCharArray();
            for(int j = 0; j < C; j++) {
                if(cArr[j] == 'X') { // 사람
                    people[i][j] = true;
                }else if(cArr[j] == 'L') { // 좌석
                    seats[i][j] = true;
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(people[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("*********");

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(solution(people, seats));
    }

    public static int solution(boolean[][] people, boolean[][] seats) {
        int answer = 0;

        for(int s1 = 0; s1 < seats.length; s1++) {
            for(int s2 = 0; s2 < seats[0].length; s2++) {
                if(seats[s1][s2]) {
                    List<int[]> dList = new LinkedList<>();
                    PriorityQueue<Integer> pq = new PriorityQueue<>();

                    for(int p1 = 0; p1 < people.length; p1++) {
                        for(int p2 = 0; p2 < people[0].length; p2++) {
                            if(people[p1][p2]) {
                                int dist = (int) (Math.pow((s1-p1),2) + Math.pow((s2-p2),2));
                                pq.add(dist);
                                dList.add(new int[]{p1, p2, dist});
                                //{0,2,dist1}, {1,1,dist2}
                            }
                        }
                    }

                    if(pq.size() > 1) {
//                        System.out.println("pq 사이즈가 1 이상");
                        int min1 = pq.poll();
                        int min2 = pq.poll();
                        if(min1 == min2) {
                            answer++;
                        } else {
//                            System.out.println("다 여기로 들어오나??");
                            for(int[] d : dList) {
                                if(min1 == d[2]) {
                                    people[d[0]][d[1]] = false;
                                }
                            }
                        }
                    } else if(pq.size() == 1) {
//                        System.out.println("pq 사이즈가 1");
                        int min1 = pq.poll();
                        int[] d = dList.get(0);
                        people[d[0]][d[1]] = false;
                    }
                }
//                System.out.println("--- 의자 하나 끝 ---");
            }
        }

        return answer;
    }
}
