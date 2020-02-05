import java.util.*;
class Solution {
  public int solution(int n) {
      List<Integer> list = new ArrayList<>();
      list.add(0);
      list.add(1);
      for(int i = 1; i <= n; i++){
          list.add((list.get(i-1) + list.get(i))%1000000007);
      }
      return list.get(n+1) % 1000000007;
  }
}
