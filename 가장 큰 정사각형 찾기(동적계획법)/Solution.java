class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;
        int max = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(i == 0 || j == 0){
                    if(board[i][j] > max)
                        max = board[i][j];
                    continue;
                }
                if(board[i][j] == 1){
                    board[i][j] += findMin(board[i-1][j-1],board[i][j-1], board[i-1][j]);
                }
                if(board[i][j] > max)
                    max = board[i][j];
            }
        }
        return max * max;
    }
    public int findMin(int a, int b, int c){
        if(a>=b)
            if(b>=c)
                return c;
            else
                return b;
        else
            if(a>=c)
                return c;
            else 
                return a;
    }
}