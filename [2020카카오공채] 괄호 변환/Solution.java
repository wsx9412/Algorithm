import java.util.*;

class Solution {

    Stack<Character> stack = new Stack<Character>();
    String u;
    String v;
    String s;
    int k;
    int leftIndex;
    int rightIndex;
    char ch;
    char leftBracket = new String("(").charAt(0);
    char rightBracket = new String(")").charAt(0);
    public String solution(String p) {
        String answer = divineString(p);
        return answer;
    }
    public String divineString(String str){
        if(check(str))
            return str;
        String u = "";
        String v = "";
        String s = "";
        if(str.isEmpty()){
            return "";
        }
        leftIndex = 0;
        rightIndex = 0;
        k = 1;
        ch = str.charAt(0);
        u += ch;
        if(ch == leftBracket)
            leftIndex++;
        else
            rightIndex++;

        while(leftIndex != rightIndex){
            ch = str.charAt(k);
            if(ch == leftBracket)
                leftIndex++;
            else
                rightIndex++;
            u += ch;
            k++;
        }
        while(k<str.length()){
            v += str.charAt(k);
            k++;
        }
        if(check(u)){
            v = divineString(v);
        System.out.println(u + " " + v);
        }
        else{
            s += "(";
            s += divineString(v);
            s += ")";
            for(int i = 1; i < u.length() - 1; i++){
                if(u.charAt(i) == leftBracket)
                    s += rightBracket;
                else
                    s += leftBracket;
            }
            u = s;
            v = "";
        }
        return u + v;
    }
    public boolean check(String str){
        stack.clear();
        for(int i = 0; i<str.length(); i++){
            ch =  str.charAt(i);
            if(stack.isEmpty())
                stack.push(ch);
            else if(stack.peek() == leftBracket && ch == rightBracket){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        System.out.println(stack);
        if(stack.isEmpty())
            return true;
        return false;
    }
}
