import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        int answer = 0;

        for(int i = 0; i<scoville.length; i++)
            heap.add(scoville[i]);

        for(int i = 0; i<scoville.length; i++){
            if( heap.size()<=1&& heap.peek() < K){
                answer = -1;
                break;
            }
            if(heap.peek()<K){
                int min = heap.poll();
                int min2 = heap.poll();
                int sco = min + (min2 * 2);
                heap.add(sco);
                answer++;
            }
            if(heap.peek() >= K)
                break;
        }


        return answer;
    }
}
