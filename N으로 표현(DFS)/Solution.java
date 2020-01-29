class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        answer = dfs(N,0,number,0,-1);
        return answer;
    }
    public int dfs(int N,int sum ,int number, int count, int minCount){
        if(count > 8)
            return minCount;
        if(sum == number){
            if(count < minCount || minCount == -1)
                return count;
        }
        int k = 0;
        for(int i = 1; i <= 8; i++){
            k = k * 10 + N;
            minCount = dfs(N,sum + k,number,count+i,minCount);
            minCount = dfs(N,sum - k,number,count+i,minCount);
            minCount = dfs(N,sum * k,number,count+i,minCount);
            minCount = dfs(N,sum / k,number,count+i,minCount);
        }
        return minCount;
    }
}
//dp를 이용하여 풀기위해 여러 패턴에서 공통점을 찾아보려 했으나 결국 찾지못해서 DFS로 풀었습니다.
