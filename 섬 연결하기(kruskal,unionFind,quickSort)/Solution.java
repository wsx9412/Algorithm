//참고 사이트 https://gmlwjd9405.github.io/2018/08/29/algorithm-kruskal-mst.html
import java.util.*;
class Solution {
    int[] unionArray;
    //크루스칼에서 각 노드의 연결사이클(집합)을 알기위해 Union-Find를 사용함
    public int solution(int n, int[][] costs) {
        Solution a = new Solution();
        unionArray = new int[n];
        quickSort(costs,0,costs.length-1);
        //각 간선의 가중치를 퀵정렬하여 오름차순으로 정렬함
        for(int i = 0; i < n; i++){
            unionArray[i] = i;
        }
        //각 노드의 부모노드를 자신으로 설정하여 아직은 연결사이클이 없음을 확인함
        int answer = 0;
        int i = 0;
        int index = 0;
        while(true){
            if(index >= n-1)
                break;
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
                index++;
            }//각노드의 연결사이클이 같지 않을경우 더해주고 연결사이클을 추가함
            i++;
        }

        return answer;
    }
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        unionArray[y] = x;
    }
    public int find(int x){
        if(unionArray[x] == x)
            return x;
        else
            return find(unionArray[x]);
    }//노드의 루트노드를 검색하기 위한 재귀함수
    public void quickSort(int[][] data, int l, int r){
        int left = l;
        int right= r;
        int pivot = data[(l+r)/2][2];
        do{
            while(data[left][2] < pivot)
                left++;
            while(data[right][2] > pivot)
                right--;
            if(left <= right){
                swap(data,left,right);
                left++;
                right--;
            }
        }while(left <= right);
        if(l < right)
            quickSort(data,l,right);
        if(r > left)
            quickSort(data,left,r);
    }//피벗을 가운데로 설정하고 왼쪽과 오른쪽부터 하나씩 가까워지며 피봇보다 큰값과 작은값의 위치를 바꿈
    public void swap(int[][] data, int left, int right){
        int temp = data[left][0];
        data[left][0] = data[right][0];
        data[right][0] = temp;
        temp = data[left][1];
        data[left][1] = data[right][1];
        data[right][1] = temp;
        temp = data[left][2];
        data[left][2] = data[right][2];
        data[right][2] = temp;
    }
}
