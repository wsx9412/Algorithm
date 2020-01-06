class Solution {
    public int solution(String s) {
        String str = "";
        String result = "";
        String minResult = s;
        String divStr = "";
        int divIndex = 1;
        int min;
        int i = 0;
        
        while(divIndex < s.length()){
            str = s;
            result = "";
            while(str.length()>0){
                i = 1;
                if(str.length() > divIndex){
                    divStr = str.substring(0,divIndex);
                    str = str.replaceFirst(divStr,"");
                }
                else{
                    result += str;
                    str = "";
                    break;
                }                    
                while(str.indexOf(divStr) == 0){
                    i++;
                    str = str.replaceFirst(divStr,"");
                }
                if(i >= 2)
                    result += i;
                result += divStr;
            }
            if(result.length() < minResult.length()){   
                minResult = result;
                min = divIndex;
            }
            divIndex++;
        }
        return minResult.length();
    }
    
}