class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        char[] rootNum;
        char[] num;
        int s,b;
        for(int i = 123; i<= 987; i++){
            num =new String(i + "").toCharArray();
            if(num[0] == new String("0").charAt(0) || num[1] == new String("0").charAt(0) || num[2] == new String("0").charAt(0) || num[0] == num[1] || num[0] == num[2] || num[1] == num[2])
                continue;
            for(int j = 0; j<baseball.length; j++){
                s = 0;
                b = 0;
                rootNum = new String(baseball[j][0] + "").toCharArray();
                if(num[0] == rootNum[0])
                    s++;
                if(num[1] == rootNum[1])
                    s++;
                if(num[2] == rootNum[2])
                    s++;
                if(baseball[j][1] != s)
                    break;
                if(num[0] == rootNum[1] || num[0] == rootNum[2])
                    b++;
                if(num[1] == rootNum[0] || num[1] == rootNum[2])
                    b++;
                if(num[2] == rootNum[0] || num[2] == rootNum[1])
                    b++;
                if(baseball[j][2] != b)
                    break;
                
                if(j == baseball.length-1)
                    answer++;
                               
            }
        }
        return answer;
    }
}