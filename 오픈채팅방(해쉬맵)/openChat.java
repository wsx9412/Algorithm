package openChat;

import java.util.*;

public class openChat {

	public String[] solution(String[] record) {
        HashMap<String,String> hash = new HashMap<String,String>();
        List<String> answer = new ArrayList<String>();
        //������, �г��� ���� ���� ������ ���� ���������� �������� �г����� ����
        for(String str:record){
            Check(hash, str);
        }
        //������ �г����� �̿��Ͽ� ����
        for(String str:record){
            SetString(hash, answer, str);
        }
        String[] result = new String[answer.size()];
        result = answer.toArray(result);
        return result;
    }
	//�г����� �����ϴ� �޼ҵ�
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
    //������ �г����� �̿��Ͽ� �����ϴ� �޼ҵ�
    public void SetString(HashMap<String,String> hash, List<String> answer, String str){
        String[] chat;
        chat = str.trim().split(" ");
        if(chat[0].equals("Enter"))
            answer.add(hash.get(chat[1])+"���� �����Խ��ϴ�.");
        else if(chat[0].equals("Leave"))
            answer.add(hash.get(chat[1])+"���� �������ϴ�.");
    }

}
