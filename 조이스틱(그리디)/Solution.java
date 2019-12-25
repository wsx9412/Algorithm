//문제 : 프로그래머스 조이스틱(그리디 알고리즘)
class Solution {
    public int solution(String name) {
        char[] alph = name.toCharArray();
        char compareAlph = 'A';
        int compareNum = (int)compareAlph;
        int[] index = new int[alph.length];
        //A인 변수는 변화가 완료된것으로 간주
        for(int i = 0; i < alph.length; i++){
            if(alph[i] == 'A')
                index[i] = 1;
            else
                index[i] = 0;
        }
        //비교하기 시작한 알파벳 위치, 넘어온 알파벳의 갯수, 최소값이었을때의 알파벳 번호, 최소값, 정답, 다음 알파벳의 번호
        int nowAlph = 0;
        int nextNum = 0;
        //우측과 왼쪽으로 이동하는 최단경로를 찾기위한 변수
        int plusX = 0;
        int minusX = 0;
        int minNum = 0;

        int answer = 0;
        for(int i = 0; i<alph.length; i++){
            if(index[nowAlph]!= 1){
              //바꿔야 되는 알파벳의 거리를 ASCII코드 값에 따라 측정하여 앞/뒤중 가까운 거리를 return 함
                answer +=  compare(compareNum, alph[nowAlph]);
                index[nowAlph] = 1;
            }
            nextNum = 0;
            plusX = nowAlph;
            minusX = nowAlph;
            //가장 가까운 A가 아니고 바뀌지 않은 변수
            for(int j = 0; j<alph.length;j++){
                nextNum++;
                plusX+=1;
                minusX-=1;
                if(plusX == alph.length)
                    plusX = 0;
                if(minusX == -1)
                    minusX = alph.length-1;
                if(alph[plusX] != 'A' && index[plusX] != 1){
                    minNum = plusX;
                    break;
                }
                if(alph[minusX] != 'A' && index[minusX] != 1){
                    minNum = minusX;
                    break;
                }

            }
            if(index[minNum] != 1){
                answer += nextNum;
                nowAlph = minNum;
            }
        }
        return answer;
    }
    public int compare(int a,int b){
        if(a>b){
            if(b-a+26 < a - b)
                return b-a+26;
            else
                return a-b;
        }
        else if(a<b){
            if(a-b+26 < b - a)
                return a-b+26;
            else
                return b-a;
        }
        else
            return 0;
    }
}
