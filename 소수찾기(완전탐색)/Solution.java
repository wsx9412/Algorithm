import java.util.*;
class Solution {
    public int solution(String numbers) {
        char[] num = numbers.toCharArray();
        List<Integer> list = new ArrayList<Integer>();
        String max = "";
        int answer = 0;
        //숫자조각 정렬
        Arrays.sort(num);
        //가장 큰 수 만들기
        for(int i = num.length-1; i >= 0; i--){
            max += num[i] + "";
        }
        //큰 수까지의 소수 검색
        for(int i = 2; i <= Integer.parseInt(max); i++){
            if(isPrime(i))
                list.add(i);
        }
        //검색된 소수가 숫자조각으로 만들수있는지 검사
        for(int i : list){
            if(isMaked(num,i)){
                //가능하면 answer + 1
                answer++;
                System.out.println(i);
            }

        }
        return answer;
    }
    //소수검색
    public boolean isPrime(int primeNum){
        for(int i = 2; i <= Math.sqrt(primeNum); i++){
            if(primeNum % i == 0)
                return false;
        }
        return true;
    }

    public boolean isMaked(char[] num, int k){
        String n = k + "";

        for(char a : num){
            n = n.replaceFirst(Character.toString(a),"");
        }

        if(n.equals(""))
            return true;
        else
            return false;
    }
}
