import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = 0;
            }
        }
        visited[0][0] = 1;
        for(int i = 0; i < puddles.length; i++){
            visited[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(i-1 >= 0 && visited[i][j] != -1 && visited[i-1][j] >= 1){
                    visited[i][j] = (visited[i][j] + visited[i-1][j]) % 1000000007;
                }
                if(j-1 >= 0 && visited[i][j] != -1&& visited[i][j-1] >= 1){
                    visited[i][j] = (visited[i][j] + visited[i][j-1]) % 1000000007;
                }
            }
        }
        return visited[m-1][n-1];
    }
}
