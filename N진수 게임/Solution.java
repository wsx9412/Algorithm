import java.util.*;
class Solution {
      String answer = "";
      String result = "";
      int index = 0;
      int number = 0;
  public String solution(int n, int t, int m, int p) {
      while(index <= t * m){
          result += addAnswer(n);
          number++;
      }
      char[] ch = result.toCharArray();
      System.out.println(result);
      for(int i = 0; i<t; i++)
        answer += String.valueOf(ch[p+m*i-1]);
      return answer;
  }
    public String addAnswer(int n){
        int a = number;
        String result = "";
        int count;
        if(a == 0){
            result += "0";
            return result;
        }
        while(a>0){
            String newNum = "";
            count = a % n;
            if(count>=10){
                switch(count){
                    case 10:
                        newNum = "A";
                        break;
                    case 11:
                        newNum = "B";
                        break;
                    case 12:
                        newNum = "C";
                        break;
                    case 13:
                        newNum = "D";
                        break;
                    case 14:
                        newNum = "E";
                        break;
                    case 15:
                        newNum = "F";
                        break;
                }
            }
            else
                newNum = Integer.toString(count);
            result = newNum + result;
            index++;
            a /= n;
        }
        return result;
    }
}
