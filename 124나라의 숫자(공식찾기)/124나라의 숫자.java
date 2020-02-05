class Solution {
  public String solution(int n) {
      String answer = "";
      int rem = 0;
      while(n > 0){
          rem = n % 3;
          n /= 3;
          if(rem == 0){
              n--;
              rem = 4;
          }
          if(rem == 3){
              rem = 4;
          }
          answer = Integer.toString(rem) + answer;
      }

      System.out.print(answer);
      return answer;
  }
}
