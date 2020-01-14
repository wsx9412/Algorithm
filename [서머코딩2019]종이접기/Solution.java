import java.util.*;
class Solution {
  public int[] solution(int n) {
      List<Integer> list = new ArrayList<>();
      int index = 1;
      list.add(0);
      while(index < n){
          list.add(0);
          for(int i = list.size()-2; i >= 0; i--){
              if(list.get(i) == 1)
                  list.add(0);
              else
                  list.add(1);
          }
          index++;
      }
      int[] answer = new int[list.size()];
      for(int i = 0; i < list.size(); i++){
          answer[i] = list.get(i);
      }
      
      return answer;
  }
}