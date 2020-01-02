class Solution {
    int sum;
    int[][] pic;
    boolean[][] table;
  public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      
      table = new boolean[m][n];
      pic = picture;
      
      
      for(int i = 0; i < m; i++){
        for(int j = 0; j< n; j++){
            if(!table[i][j] && pic[i][j] != 0){
                int area = findBlock(i,j);
                numberOfArea++;
                if(area>maxSizeOfOneArea)
                    maxSizeOfOneArea = area;
            }            
        } 
      }          
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
    public int findBlock(int m, int n){
        sum = 1;
        table[m][n] = true;
        if(n > 0 && pic[m][n] == pic[m][n-1] && !table[m][n-1])
            sum += findBlock(m,n-1);
        if(n + 1 < pic[m].length && pic[m][n] == pic[m][n+1] && !table[m][n+1])
            sum += findBlock(m,n+1);
        if(m + 1 < pic.length && pic[m][n] == pic[m+1][n] && !table[m+1][n])
            sum += findBlock(m+1,n);
        if(m > 0 && pic[m][n] == pic[m-1][n] && !table[m-1][n])
            sum += findBlock(m-1,n);
        return sum;
    }
}