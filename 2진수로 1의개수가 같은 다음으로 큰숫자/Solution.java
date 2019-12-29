class Solution {
  public int solution(int n) {
      int answer = 0;
        int countNumber = count(n);
      while(true){
          n++;
          if(count(n) == countNumber)
              break;
      }
      return n;
  }
    public int count(int n){
        int a = n;
        int count = 0;
        while(a > 0)
        {
        count += a%2;
        a /= 2;
        }
        return count;
    }
}