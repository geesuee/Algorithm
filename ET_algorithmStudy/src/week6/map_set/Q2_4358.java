// [백준] 생태학
// https://www.acmicpc.net/problem/4358

package week6.map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class Q2_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int totalNum = 0;
        String tree = br.readLine();
        while (tree != null) {
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
