class Solution {
// 문제의 테스트케이스에선 합격했으나 효율성 테스트에서 실패함
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int rangeNumber = 0;
        int i = 0;
        int j = 0;
        boolean[] range = new boolean[n];
        for(int a: stations){
            for(i = a - w-1; i<=a+w-1; i++){
                if(i>=n)
                    break;
                if(i>=0){
                    range[i] = true;
                }
                    
            }                
        }
        while(rangeNumber < n)
        { 
            if(!range[rangeNumber]){  
                for(i = rangeNumber; i<=rangeNumber+w; i++){
                    if(i >= n-1)
                        break;
                    if(range[i]){
                        break;
                    }
                    else{
                        range[i] = true;
                    }
                }
                for(j = i; j<=i+w-1;j++){
                    if(j<n && !range[j]){
                        range[j] = true;                   
                    }
                }
                rangeNumber = j;
                answer++;
                if(rangeNumber >= n-1)
                    break;
            }else{
                rangeNumber++;                
            }
        }
        return answer;
    }
}