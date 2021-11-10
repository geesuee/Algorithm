// [프로그래머스] 단속 카메라
// https://programmers.co.kr/learn/courses/30/lessons/42884
// 참고 : https://programmers.co.kr/questions/14636

package week15.Advanced;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q3_42884 {

    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        List<int[]> list = new LinkedList<>(Arrays.asList(routes));
        //System.out.println(Arrays.toString(list.get(0)));

        // 먼저 나가는 순서로 정렬
        list.sort((v1, v2) -> v1[1] - v2[1]);
        //System.out.println(Arrays.toString(list.get(0)));

        while(!list.isEmpty()) {
            // 가장 빨리 빠져나가는 차가 나가는 시점에 카메라 설치
            int spot = list.get(0)[1];

            // 위 spot을 지나가는 차량 list에서 삭제
            for (int i = 0; i < list.size(); i++) {
                // 진입지점이 카메라 지점보다 앞이거나 같다면 = 카메라를 지나간다면
                // 진출지점 순으로 정렬해두었기 때문에 진입시점만 체크
                if (list.get(i)[0] <= spot) {
                    list.remove(i); // 진출지점 순 정렬이기 때문에 맨 앞 데이터부터 빠짐
                    i--; // 맨 앞 데이터가 빠지도록, 반복문 안에서 i를 계속 0으로 유지
                }
            }

            answer++;
        }

        return answer;
    }
}
