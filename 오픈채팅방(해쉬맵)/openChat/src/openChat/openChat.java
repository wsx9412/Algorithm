package openChat;

import java.util.*;

public class openChat {
	
	public String[] solution(String[] record) {
        HashMap<String,String> hash = new HashMap<String,String>();
        List<String> answer = new ArrayList<String>();
        //입장시, 닉네임 변경 등의 과정을 거쳐 최종적으로 사람들의 닉네임을 결정
        for(String str:record){
            Check(hash, str);
        }
        //결정된 닉네임을 이용하여 출력
        for(String str:record){
            SetString(hash, answer, str);
        }
        String[] result = new String[answer.size()];
        result = answer.toArray(result);
        return result;
    }
	//닉네임을 결정하는 메소드
    public void Check(HashMap<String,String> hash, String str){
        String[] chat;
        chat = str.trim().split(" ");
        if(chat[0].equals("Enter"))
            hash.put(chat[1],chat[2]);
        else if(chat[0].equals("Change")){
            hash.remove(chat[1]);
            hash.put(chat[1],chat[2]);
        }     
    }
    //결정된 닉네임을 이용하여 출력하는 메소드
    public void SetString(HashMap<String,String> hash, List<String> answer, String str){ 
        String[] chat;
        chat = str.trim().split(" ");
        if(chat[0].equals("Enter"))
            answer.add(hash.get(chat[1])+"님이 들어왔습니다.");
        else if(chat[0].equals("Leave"))
            answer.add(hash.get(chat[1])+"님이 나갔습니다.");
    }
    
}
