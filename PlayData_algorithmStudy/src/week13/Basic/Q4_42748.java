// [프로그래머스] K번째 수
// https://programmers.co.kr/learn/courses/30/lessons/42748

package week13.Basic;

import java.util.Arrays;

public class Q4_42748 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        for(int a : solution(array, commands)) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int cnt = 0;
        for(int[] c : commands) {
            int[] select = new int[c[1]-c[0]+1];
            for(int i = 0; i < select.length; i++) {
                select[i] = array[c[0]-1+i];
            }
            Arrays.sort(select);
            answer[cnt] = select[c[2]-1];
            cnt++;
        }

        return answer;
    }

    // 프로그래머스에서 찾은 더 훌륭한 풀이!
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            // Arrays.copyOfRange : 배열 부분 복사,
            // (복사할 배열, 복사시작 인덱스, 복사 끝 인덱스=이 인덱스 바로 전까지 복사)
            // (복사할 배열, 복사할 길이=맨 앞에서부터 이 길이만큼 복사)
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
