// [프로그래머스] 같은 숫자는 싫어
// https://programmers.co.kr/learn/courses/30/lessons/12906

package algorithm1;

import java.util.ArrayList;

public class Q6_12906 {
    public static int[] solution(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length-1 ; i++) {
            if (arr[i] == arr[i+1]) {
                if(i == arr.length-2){
                    ans.add(arr[i]);
                }
                continue;
            }
            else {
                ans.add(arr[i]);
                if(i == arr.length-2){
                    ans.add(arr[i+1]);
                }
            }
        }

        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
