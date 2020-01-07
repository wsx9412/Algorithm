import java.util.*;
class Solution {
    PriorityQueue<Integer> heap;
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        heap = new PriorityQueue<>(Collections.reverseOrder()); 
        int answer = 0;
        int j = 0;
        for(int i = 0; i < k; i++){
            stock--;
            if(stock < 0){
                while(j<dates.length && dates[j] <= i ){
                    heap.add(supplies[j]);
                    j++;
                }
                stock+=heap.poll();
                answer++;
            }                
        }
        return answer;
    }
}