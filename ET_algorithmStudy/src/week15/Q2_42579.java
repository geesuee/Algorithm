// [프로그래머스] 베스트앨범
// https://programmers.co.kr/learn/courses/30/lessons/42579

package week15;

import java.util.*;

public class Q2_42579 {

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        [4, 1, 3, 0]

        String[] genres = {"classic", "classic", "classic", "classic", "pop"};
        int[] plays = {500, 150, 800, 800, 2500};
//        [4, 2, 3]

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        // 4. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        // map : 장르별(key) 재생횟수 총합(value) 저장
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        // 재생횟수 총합(value) 기준 정렬
        List<String> map1KeySet = new ArrayList<>(map.keySet());
        map1KeySet.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        List<String> genre_order = new LinkedList<>(map1KeySet);

//        for(String g : genre_order) {
//            System.out.println(g);
//        }

        // 장르별 최다 재생 곡 탐색
        for(int i = 0; i < genre_order.size(); i++) {
            String g = genre_order.get(i);

            int max1 = 0;
            int idx1 = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max1 < plays[j]) {
                    max1 = plays[j];
                    idx1 = j;
                }
            }

            int max2 = 0;
            int idx2 = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max2 < plays[j] && j != idx1) {
                    max2 = plays[j];
                    idx2 = j;
                }
            }

            answer.add(idx1);
            if(idx2 != -1) { // idx2는 존재하지 않을 수 있음
                answer.add(idx2);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
