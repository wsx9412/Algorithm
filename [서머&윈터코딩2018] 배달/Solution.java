import java.util.*;
class Solution {
    int[] time;
    PriorityQueue<Integer> p_queue;
    //다익스트라 구현을 위해 힙(우선순위큐)을 사용함
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        p_queue = new PriorityQueue<>();
        time = new int[N];
        //1번노드와의 이동시간만 나타내면 되므로 이중배열을 사용할 필요가 없음
        p_queue.add(1);
        Arrays.fill(time, 1000000);
        time[0] = 0;

        while(!p_queue.isEmpty()){
            int index = p_queue.poll();
            for(int i = 0; i < road.length; i++){
              //배열의 0번째와 1번째의 값이 무작위의 순서로 들어있으므로 양쪽의 경우 모두 계산해야함
                if(road[i][0] == index){
                    setTime(i, index, 1, road);
                } else if(road[i][1] == index){
                    setTime(i, index, 0, road);
                }
            }
        }

        for(int i = 0; i < time.length; i++){
            if(time[i] <= K)
                answer++;
        }

        return answer;
    }
    public void setTime(int i, int index, int y ,int[][] road){
        if(time[road[i][y]-1] >  time[index-1] + road[i][2]){
            p_queue.add(road[i][y]);
            time[road[i][y]-1] = time[index-1] + road[i][2];
        }
    }
}
