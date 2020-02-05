import java.util.*;
import java.math.*;
class Solution {
    int max;
    double time;
    double[][] sec;

  public int solution(String[] lines) {
      sec = new double[lines.length][2];
      max = 0;
      setData(lines);
      getMax();
      return max;
  }
    public void setData(String[] lines) {
      for(int i = 0; i < lines.length; i++){
          time = 0;
          time += Integer.parseInt(lines[i].substring(11,13)) * 3600;
          time += Integer.parseInt(lines[i].substring(14,16)) * 60;
          time += Double.parseDouble(lines[i].substring(17,23));
          sec[i][0] = time;
          sec[i][1] = Double.parseDouble(lines[i].substring(24,lines[i].length()-1));
      }
    }

    public void getMax(){
        int startMax,endMax;
        BigDecimal start1;
        BigDecimal start2;
        BigDecimal end1;
        BigDecimal end2;
        for(int i = 0; i < sec.length; i++){
            end1 = BigDecimal.valueOf(sec[i][0]);
            start1 = end1.add(BigDecimal.valueOf(0.001));
            start1 = start1.subtract(BigDecimal.valueOf(sec[i][1]));
            startMax = 0;
            endMax = 0;
            for(int j = 0; j < sec.length; j++){
                end2 = BigDecimal.valueOf(sec[j][0]);
                start2 = end1.subtract(BigDecimal.valueOf(sec[j][1]));
                start2 = end2.add(BigDecimal.valueOf(0.001));
                if((end1.compareTo(end1) <= 0 && end1.add(BigDecimal.valueOf(0.999)).compareTo(start2) >= 0)
                   || (end1.compareTo(end1) <=0 && end1.add(BigDecimal.valueOf(0.999)).compareTo(start2) >= 0)){
                    startMax++;
                }
                if((start1.compareTo(end1) <= 0 && start1.add(BigDecimal.valueOf(0.999)).compareTo(start2) >= 0)
                   || (start1.compareTo(end1) <=0 && start1.add(BigDecimal.valueOf(0.999)).compareTo(start2)>= 0)){
                    endMax++;
                }
            }
            if(max == 0)
                max = startMax;
            if(startMax > endMax){
                if(max < startMax)
                    max = startMax;
            }
            else if(startMax <= endMax){
                if(max < endMax)
                    max = endMax;
            }
        }
    }
}
