// [프로그래머스] 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587

package week10.linkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Q1_42587 {

    public static void main(String[] args) {
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        //  / A 1 9 1 1 1
        //  / 1 9 1 1 1 A
        //  / 9 1 1 1 A 1
        // 9 / 1 1 1 A 1
        // 9 1 / 1 1 A 1
        // 9 1 1 / 1 A 1
        // 9 1 1 1 / A 1
        // 9 1 1 1 A / 1
        // 9 1 1 1 A 1 /    => 5번쨰로 출력

//        int[] priorities = {4, 3, 3, 4, 2, 1, 1, 3};
//        int location = 5;
        //  / 4 3 3 4 2 A 1 3
        // 4 / 3 3 4 2 A 1 3
        // 4 / 3 4 2 A 1 3 3
        // 4 / 4 2 A 1 3 3 3
        // 4 4 / 2 A 1 3 3 3
        // 4 4 / A 1 3 3 3 2
        // 4 4 / 1 3 3 3 2 A
        // 4 4 / 3 3 3 2 A 1
        // 4 4 3 / 3 3 2 A 1
        // 4 4 3 3 / 3 2 A 1
        // 4 4 3 3 3 / 2 A 1
        // 4 4 3 3 3 2 / A 1
        // 4 4 3 3 3 2 A / 1
        // 4 4 3 3 3 2 A 1 /    => 7번쨰로 출력

//        int[] priorities = {1,2,8,3,4};
//        int location = 4; //2

//        int[] priorities = {1, 1, 1, 1, 1, 1};
//        int location = 3; //4

//        int[] priorities = {2, 3, 3, 2, 9, 3, 3};
//        int location = 3; //6

//        int[] priorities = {2, 1, 9, 1, 9, 1};
//        int location = 1;  //4

//        int[] priorities = {2, 1, 2, 1, 2};
//        int location = 3;  //5
//        int location = 4;  //3
//        int location = 1;  //4

//        int[] priorities = {1, 1, 1, 2};
//        int location = 1;  //3

//        int[] priorities = {1, 1, 1};
//        int location = 1;  //2

        int[] priorities = {3, 3, 4, 2};
        int location = 3;  //4

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  //우선순위를 큰 숫자로 변경
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }

    // 이 코드는 왜 틀렸을까..?
    public static int trial(int[] priorities, int location) {

        LinkedList<Integer> wait = new LinkedList<>();
        for(int p : priorities) {
            wait.add(p);
        }

        List<Integer> printed = new LinkedList<>();
        int order = 0;
        int cnt = 0;

        while(!wait.isEmpty()) {
            int first = wait.poll();
            boolean check = false;
            for(int i = 0; i < wait.size(); i++) {
                if(first < wait.get(i)) { //뒤에 더 큰 수가 있는 경우
                    check = true;
                    break;
                }
            }
            if(check == false) { //우선순위가 밀리지 않은 경우
                printed.add(first);
                if(cnt == location) {
                    order = printed.size();
                    return order;
                }
            }else { //우선순위가 밀린 경우
                wait.add(first);
                if(cnt == location) {
                    order = printed.size() + wait.size();
                } else if(cnt > location) {
                    order--;
                }
            }
            cnt++;
        }

        return order;
    }
}
