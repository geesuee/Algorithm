// [프로그래머스] 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587
// 미완..왜 틀렸을까?ㅜ

package week10.linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1_42587 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
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

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        //priorities를 하나씩 wait 큐에 담음
        //반복문으로 순회해서 맨 앞에 있는 것의 우선순위 비교
            //우선순위가 밀린다면
                //wait.poll(), poll한 값을 다시 add
                //
            //우선순위상 맨 앞이라면
                //wait.poll(), poll한 값을 printed 연결리스트에 add
                //
        //순서를 파악하려면?
            //반복문 돌 때, i >= location이면
                //i == location일 때 처음 진입,
                    //우선순위가 밀린다면 => order = prited.size() + wait.size()
                    //우선순위상 맨 앞이라면 => order = printed.size() 여기서 끝내버리기!!!
                //i == location+1 일 때,
                    //우선순위가 밀린다면 => order = printed.size() + wait.size() -1
                    //우선순위상 맨 앞이라면 => order = prited.size() + wait.size()

        Queue<Integer> wait = new LinkedList<>();
        for(int p : priorities) {
            wait.add(p);
        }

        List<Integer> printed = new LinkedList<>();
        int plen = priorities.length;
        int order = 0;
        int cnt = 0;

        for(int i = 0; i < wait.size(); i++) {
            for(int j = 0; j < wait.size(); j++) {
                if(priorities[i] < priorities[j]) { //우선순위 밀리는지 확인
                    cnt++;
                    System.out.println(priorities[i] + " / " + priorities[j] + " / " + "cnt : " + cnt);
                    break;
                }
            }
            if(cnt > 0) { //우선순위 밀림
                System.out.println(priorities[i] + " 뒤로 빠집니당");
                wait.add(wait.poll());
                if(i == location) {
                    order = printed.size() + wait.size();
                } else if (i > location) {
                    order--;
                }
            }else { //우선순위상 맨 앞
                System.out.println(priorities[i] + " 프린트 됩니당");
                printed.add(wait.poll());
                if(i == location) {
                    order = printed.size();
                    System.out.println(i + "번쨰이고, 우선순위 맨 앞이라서 이제 그만한다!");
                    return order;
                }
            }
            cnt = 0;
        }

        return order;
    }
}
