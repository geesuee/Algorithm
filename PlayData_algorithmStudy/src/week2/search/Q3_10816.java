// [백준] 10816번 : 숫자 카드2
// https://www.acmicpc.net/problem/10816

package week2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q3_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> checkList = new HashMap<>();
        int[] order = new int[M];
        for(int i = 0; i < M; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            checkList.put(order[i], 0);
        }

        System.out.println(checkCards(cards, checkList, order));
    }

    public static String checkCards(int[] cards, HashMap<Integer, Integer> checkList, int[] order) {
        for(int card : cards) {
            if(checkList.containsKey(card)) {
                checkList.put(card, checkList.get(card) + 1);
            }
        }

        // checkList 안의 value 순서대로 뽑아서 return
        StringBuilder sb = new StringBuilder();
        for(int number : order) {
            sb.append(checkList.get(number) + " ");
        }

        return sb.toString().trim();
    }
}
