// [프로그래머스] 모의고사
// https://programmers.co.kr/learn/courses/30/lessons/42840

package week2.search;

import java.util.ArrayList;

public class Q1_42840 {
    public static int[] solution(int[] answers) {
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == ans1[i % ans1.length]) {score1++;}
            if(answers[i] == ans2[i % ans2.length]) {score2++;}
            if(answers[i] == ans3[i % ans3.length]) {score3++;}
        }

        int topScore = Math.max(Math.max(score1, score2), score3);

        ArrayList<Integer> winner = new ArrayList<>();
        if(score1 == topScore) {winner.add(1);}
        if(score2 == topScore) {winner.add(2);}
        if(score3 == topScore) {winner.add(3);}

        int size = winner.size();
        int[] answer = winner.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
