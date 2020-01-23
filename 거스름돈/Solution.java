import java.util.*;
class Solution {
    int sum;
  public int solution(int n, int[] money) {
      int[] answer;
      Arrays.sort(money);
      answer = count(money.length, n, money );
      return answer[n-1] % 1000000007;
  }
    //n원까지 거슬러줄수있는 방법의 갯수를 배열로 저장하고 일정한 패턴에 따라 총 갯수를 파악함
    public int[] count(int index, int n ,int[] money){
        int[] sum = new int[n];
        for(int i = 0; i < index; i++){
         for(int j = money[i]-1; j <= n-1 ; j++){
             if(j == money[i]-1)
                sum[j] += 1;
             else
                sum[j] += sum[j-money[i]];
         }   
        }       
        return sum;
    }
}