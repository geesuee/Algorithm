// [백준] 트럭
// https://www.acmicpc.net/problem/13335

package week12.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1_13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); //트럭의 수
        int w = Integer.parseInt(st.nextToken()); //다리의 길이
        int L = Integer.parseInt(st.nextToken()); //다리의 최대 하중

        st = new StringTokenizer(br.readLine(), " ");
        int[] truckList = new int[n];
        for(int i = 0; i < n; i++) {
            truckList[i] = Integer.parseInt(st.nextToken());
        }

        //queue
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int weight = 0;

        for(int truck : truckList) {
            while(true) {
                if(queue.isEmpty()) { //다리에 트럭이 하나도 없을 때
                    queue.add(truck);
                    weight += truck;
                    time++;
                    break; //트럭을 다리에 올렸으니 다음 트럭으로 넘어감
                } else if(queue.size() == w) { //다리에 트럭이 다 차있을 때
                    int out = queue.poll();
                    weight -= out;
                } else { //그 외 무게 넘지 않게 트럭 이동해야 할 때
                    if(weight + truck <= L) { //트럭이 올라갈 수 있을 때
                        queue.add(truck);
                        weight += truck;
                        time++;
                        break; //트럭을 다리에 올렸으니 다음 트럭으로 넘어감
                    }else { //트럭이 올라갈 수 없을 때, 빈 자리 0으로 채움
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        System.out.println(time + w); //트럭을 모두 다리에 올린 뒤, 마지막 트럭 다리 건너기
    }
}
