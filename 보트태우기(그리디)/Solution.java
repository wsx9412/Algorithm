import java.util.*;
class Solution {
  //맨 처음 배열을 이용하여 시도했으나 실패하여 스택을 이용하여 해결
    public int solution(int[] people, int limit) {
        int answer = 0;
        int top = 0;
        Arrays.sort(people);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = people.length-1; i >= 0; i--){
            if(top == 0){
                stack.push(people[i]);
                top++;
            }
            else
            {
                if(stack.peek() + people[i] <= limit){
                    stack.pop();
                    answer++;
                    top--;
                }
                else{
                    stack.push(people[i]);
                    top++;
                }
            }
        }
        for(int i = 0; i<top; i++)
            answer++;

        return answer;
    }
        /*int answer = 0;

        Arrays.sort(people);


        for(int i=people.length-1; i>=0; i--){
            if(people[i] != 0){
                answer++;
                int result = findNum(people,i,limit);
                if(result == -1){
                    people[i] = 0;
                }
                else{
                    people[i] = 0;
                    people[result] = 0;
                }

            }
        }
        return answer;
    }
    public int findNum(int[]people,int firstNum,int limit){
        int divpoint = -1;
        for(int i = 0; i<firstNum; i++){
            if(people[i] == 0)
                continue;
            if(people[i] + people[firstNum] > limit){
                break;
            }else if(people[i] + people[firstNum] <= limit){
                divpoint = i;
            }
        }
        return divpoint;

    }*/
}
