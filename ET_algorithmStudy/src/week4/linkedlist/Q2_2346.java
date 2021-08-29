// [백준] 풍선 터뜨리기
// https://www.acmicpc.net/problem/2346
// *시간 초과 -> LinkedList 활용한 풀이로 수정 필요

package week4.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class Q2_2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int totalNum = 0;
        String tree = br.readLine();
        while (tree != null && tree.length() != 0) {
            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
            totalNum++;
            tree = br.readLine();
        }

        Iterator<String> keyAll = treeMap.keySet().iterator();
        String key = null;
        while(keyAll.hasNext()) {
            key = keyAll.next();
            double per = (double)(treeMap.get(key)*100)/totalNum;
            System.out.println(key + " " + String.format("%.4f", per));
        }
    }
}
