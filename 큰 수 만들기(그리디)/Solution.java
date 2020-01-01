import java.util.*;
class Solution {
    public String solution(String number, int k)
    {
        String answer = "";
        char[] numbers = number.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        
        for(char a : numbers){     
            while(!stack.isEmpty() && k > 0 &&stack.peek() - '0' < a - '0'  )
            {
                stack.pop();
                k--;
            }
            if(stack.size() == number.length() - k && numbers[numbers.length-1] == a)
                break;
            stack.push(a);        
        }             
        for(int i = 0; i <stack.size() ; i++)
            answer += stack.get(i);
        
        return answer;
    }
}