import java.util.*;
class Solution {
    PriorityQueue<Integer> queue;
    public int solution(int n, int[][] computers) {
        queue = new PriorityQueue<>();
        int net_num = 1;
        int[] network = new int[n];
        for(int i = 0; i < n; i++){
            if(network[i] == 0){
                queue.add(i);
                while(!queue.isEmpty()){
                    int index = queue.remove();
                    for(int j = 0; j < n; j++){
                        if(computers[index][j] == 1 && network[j] == 0){
                            queue.add(j);
                            network[j] = net_num;
                        }
                    }
                }
                net_num++;
            }
        }
        return net_num-1;
    }
}
