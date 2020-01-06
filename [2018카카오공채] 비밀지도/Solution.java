class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      mapping(answer, arr1, arr2, n);
      return answer;
  }
    public void mapping(String[] answer, int[] arr1, int[] arr2, int n){
        int[] bin1 = new int[n];
        int[] bin2 = new int[n];
        for(int i = 0; i < n; i++){
            String a = "";
            for(int j = n-1; j>=0; j--){
                bin1[j] = arr1[i] % 2;
                bin2[j] = arr2[i] % 2;
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            for(int j = 0; j<n; j++)
            {
                if(bin1[j] == 1 || bin2[j] == 1)
                    a += "#";
                else
                    a += " ";
            }
            answer[i] = a;
            System.out.println(a);
        }
    }

}
