import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int Hindex = 0;
        int index = 1;
        int i = citations.length - 1;
        while(true){
            if(citations[0] > citations.length){
                Hindex = citations.length;   
                break;
            }
            if(i >= 0){
                Hindex = citations[i];
                index++;               
                i--;
            }
            while(Hindex > citations[i-1]){
                if(Hindex <= index)
                    break;
                Hindex--;
            }
            if(Hindex <= index)
                break;
        }
        return Hindex;
    }
}