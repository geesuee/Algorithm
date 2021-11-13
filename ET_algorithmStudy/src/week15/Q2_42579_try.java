// [프로그래머스] 베스트앨범
// https://programmers.co.kr/learn/courses/30/lessons/42579
// 실패
// 추정 원인 : 장르별 최대 재생 곡 인덱스 갱신 및 추출 부분 알고리즘

package week15;

import java.util.*;

public class Q2_42579_try {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        // map1 : 장르별(key) 재생횟수 총합(value) 저장
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

        // 많이 재생된 장르 순서대로 돌면서
        // 최대 재생횟수와 index 저장 및 갱신
        // max1이 갱신되면 이전 max1 값을 max2로 넘김
        for(String g : genre_order) {
            int[][] maxvalues = new int[2][2];
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(g)) {
                    if(maxvalues[0][0] < plays[i]) {
                        if(maxvalues[1][0] < maxvalues[0][0]) {
                            maxvalues[1][0] = maxvalues[0][0];
                            maxvalues[1][1] = maxvalues[0][1];
                        }
                        maxvalues[0][0] = plays[i];
                        maxvalues[0][1] = i;
//                        System.out.println(maxvalues[0][0] + " *** " + maxvalues[0][1]);
                    }
                    else if(maxvalues[1][0] < plays[i]) {
                        maxvalues[1][0] = plays[i];
                        maxvalues[1][1] = i;
//                        System.out.println(maxvalues[1][0] + " *** " + maxvalues[1][1]);
                    }
                }
            }

            answer.add(maxvalues[0][1]);
            answer.add(maxvalues[1][1]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
