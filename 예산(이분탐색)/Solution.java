import java.util.*;
class Solution {
    long root;
    long sum;
    int mid;
    int max;
    public int solution(int[] budgets, int M) {
        int answer = 0;
        sum = (long)0;
        Arrays.sort(budgets);
        if((long)budgets[0] * (long)budgets.length > (long)M){
            answer = M / budgets.length;
            return answer;
        }
        for(int i = 0; i < budgets.length; i++){
            sum += (long)budgets[i];
        }
        if(sum <= (long)M){
            answer = budgets[budgets.length-1];
        }else{
            answer = binaryFind(budgets,M);
        }
        return answer;
    }
    public int binaryFind(int[] data, int M){
        int low = 0;
        int high = data[data.length-1];
        int result = 0;
        while(low <= high){
            mid = (low+high)/2;
            root = 0;
            sum = check(data,mid);
            if(sum > M)
                high = mid - 1;
            else if(sum < M){
                low = mid + 1;
                result = mid;
            }
            else{
                return mid;
            }

        }
        return result;
    }
    public long check(int[] data, int limit){
        long sum = 0;
        for(int i : data){
            if(i > limit){
                i = limit;
            }
            sum += (long)i;
        }
        return sum;
    }
}
