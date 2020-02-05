import java.util.*;
class Solution {
    String head1;
    String head2;
    String number1;
    String number2;

  public String[] solution(String[] files) {
      String[] answer = {};
      List<String> array = Arrays.asList(files);
      array.sort(new Comparator<String>(){
          @Override
          public int compare(String arg0, String arg1){
              int i = 0;
              char a;
              arg0.trim();
              arg1.trim();
              head1 = "";
              head2 = "";
              number1 = "";
              number2 = "";
              while(i < arg0.length()){
                  a = arg0.charAt(i);
                  if(48 <= (int)a && (int)a <= 57)
                      break;
                  else
                    head1 += arg0.charAt(i);
                  i++;
              }
              while(i < arg0.length()){
                  a = arg0.charAt(i);
                  if(48 <= (int)a && (int)a <= 57)
                      number1 += arg0.charAt(i);
                  else
                      break;
                  i++;
              }
              i = 0;
              while(i < arg1.length()){
                  a = arg1.charAt(i);
                  if(48 <= (int)a && (int)a <= 57)
                      break;
                  else
                    head2 += arg1.charAt(i);
                  i++;
              }
              while(i < arg1.length()){
                  a = arg1.charAt(i);
                  if(48 <= (int)a && (int)a <= 57)
                      number2 += arg1.charAt(i);
                  else
                      break;
                  i++;
              }
              head1 = head1.toLowerCase();
              head2 = head2.toLowerCase();
              int compared = head1.compareTo(head2);
              if(compared>0)
                  return 1;
              else if(compared == 0){
                  compared = Integer.compare(Integer.parseInt(number1),Integer.parseInt(number2));
                  if(compared>0)
                      return 1;
                  else if(compared == 0)
                      return 0;
                  else
                      return -1;
              }
              else
                  return -1;
          }
      });
      answer = array.toArray(new String[array.size()]);
      return answer;
  }
}
