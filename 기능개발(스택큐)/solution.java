package solution;

import java.util.*;

class Solution {
	public static void main(String[]args) {
		Solution mySolution = new Solution();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		mySolution.solution(progresses,speeds);
	}
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> list = new LinkedList<Integer>();
        Queue<Integer> speed = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int day = 0;
        int work = 0;
        int endWork = 0;
        for(int i = 0 ; i < progresses.length; i++){
            list.offer(progresses[i]);
            speed.offer(speeds[i]);
        }
        do{
            work = list.peek() + (speed.peek() * day);
            if(work >= 100){
            	list.poll();
            	speed.poll();
            	endWork++;
                if(list.isEmpty())
                	result.add(endWork);
            }else{
                if(endWork != 0){
                    result.add(endWork);
                    endWork = 0;
                }
                day++;
            }
        }while(!list.isEmpty());
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size();i++){
            answer[i] = result.get(i);
            System.out.println(result.get(i));
        }
        return answer;
    }
}
