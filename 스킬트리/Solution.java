class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] sk = skill.toCharArray();
        for(int i = 0; i<skill_trees.length; i++){
            String comp = "";
            char[] tr = skill_trees[i].toCharArray();
            for(int j = 0; j<tr.length; j++){
                for(int k = 0; k<sk.length; k++){
                    if(tr[j] == sk[k])
                        comp+=tr[j];
                }
            }//스킬트리가 존재하는 스킬을 따옴
            int index = 0;
            char[] com = comp.toCharArray();
            for(char a : com){
                if(a != sk[index])
                    break;
                index++;
            }//스킬트리에 맞게 스킬을 찍었는지 확인
            if(comp.length() == index)
                answer++;
        }
        return answer;
    }
}
