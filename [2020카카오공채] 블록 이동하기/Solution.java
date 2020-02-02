import java.util.*;
class Solution {
    static int MAP_SIZE;
    static int[][][] visited;
    static Queue<robot> queue;
    class robot{
        int[][] rotate = {{1,0},{0,1},{-1,0},{0,-1}};
        //루트노드에서 어느 방향으로 뻗어나가있는지 확인하기위해 배열을 사용하여 표현했습니다.
        int x1,y1,x2,y2,p,time;
        public robot(int x, int y, int p, int time){
            x1 = x;
            y1 = y;
            x2 = x1 + rotate[p][0];
            y2 = y1 + rotate[p][1];
            visited[x1][y1][p] = 1;
            visited[x2][y2][(p+2)%4] = 1;
            //첫번째 루트노드에서 뻗어나간 값과 두번째 노드값이 뻗어나갔을때 형태 및 위치가 같으면 이미 방문했던 방식으로 처리합니다.
            this.p = p;
            this.time = time;
        }
        public boolean move_check(int[][] board, int move_index){
            int add_x = rotate[move_index][0];
            int add_y = rotate[move_index][1];

            return x1+add_x>=0 && x2+add_x>=0 && x1+add_x<MAP_SIZE&&x2+add_x<MAP_SIZE
                &&y1+add_y>=0 && y2+add_y>=0 && y1+add_y<MAP_SIZE&&y2+add_y<MAP_SIZE
                &&board[y1+add_y][x1+add_x] != 1 &&board[y2+add_y][x2+add_x] != 1;
                //블럭의 이동이 가능한지 체크합니다.
        }
        public void move(int[][] board, int move_index){
            if(move_check(board, move_index)){
                if(visited[x1+rotate[move_index][0]][y1+rotate[move_index][1]][p] != 1){
                    queue.add(new robot(x1+rotate[move_index][0],y1+rotate[move_index][1],p,time+1));
                    //블럭의 이동이 가능하면 큐에 추가합니다.
                }
            }
        }
        public boolean rotate_check(int[][] board, int shaft_x, int shaft_y,int clockwise,int rotate_p){
            int rotate_x;
            int rotate_y;
            int wall_x;
            int wall_y;
            if(clockwise == 1){
                wall_x = shaft_x + rotate[(rotate_p + 1) % 4][0];
                wall_y = shaft_y + rotate[(rotate_p + 1) % 4][1];
            }else{
                wall_x = shaft_x + rotate[(rotate_p-1+4)%4][0];
                wall_y = shaft_y + rotate[(rotate_p-1+4)%4][1];
            }
            rotate_x = wall_x;
            rotate_y = wall_y;
            if(wall_x == shaft_x){
                wall_x = shaft_x + rotate[rotate_p][0];
            }else{
                wall_y = shaft_y + rotate[rotate_p][1];
            }
            //회전하기위해 필요한 공간과 회전한 뒤에 벽이 있는지 확인합니다.
            return wall_x >= 0 && wall_x < MAP_SIZE && wall_y >= 0 && wall_y < MAP_SIZE
                && board[wall_y][wall_x] != 1 && board[rotate_y][rotate_x] != 1;
        }
        public void rotation(int[][] board){
          //첫번째 노드가 루트일 때와 두번째 노드가 루트일 때, 각각 시계방향과 반시계방향으로 회전할 수 있는지 확인 및 회전합니다.
            if(rotate_check(board,x1,y1,1,p)){
                if(visited[x1][y1][(p+1)%4] != 1)
                    queue.add(new robot(x1,y1,(p+1)%4,time+1));
            }
            if(rotate_check(board,x1,y1,0,p)){
                if(visited[x1][y1][(p-1+4)%4] != 1)
                    queue.add(new robot(x1,y1,(p-1+4)%4,time+1));
            }
            if(rotate_check(board,x2,y2,1,(p+2)%4)){
                if(visited[x2][y2][(p-1+4)%4] != 1)
                    queue.add(new robot(x2,y2,(p-1+4)%4,time+1));
            }
            if(rotate_check(board,x2,y2,0,(p+2)%4)){
                if(visited[x2][y2][(p+1)%4] != 1)
                    queue.add(new robot(x2,y2,(p+1)%4,time+1));
            }
        }
    }
    public int solution(int[][] board) {
        MAP_SIZE = board.length;
        queue = new LinkedList<>();
        visited = new int[100][100][4];
        queue.add(new robot(0,0,0,0));
        while(!queue.isEmpty()){
          //BFS를 Queue를 이용하여 구현하였습니다.
            robot r = queue.remove();
            int x1 = r.x1;
            int x2 = r.x2;
            int y1 = r.y1;
            int y2 = r.y2;
            int time = r.time;
            //블럭이 목표에 도달하면 걸린 시간을 return하여 반복문을 종료합니다. BFS이므로 가장 처음에 나오는 return값이 최솟값입니다.
            if((x1 == MAP_SIZE-1 && y1 == MAP_SIZE-1 ) || (x2 == MAP_SIZE-1 && y2 == MAP_SIZE-1 ))
                return time;
            for(int i = 0; i < 4; i++){
                r.move(board,i);
            }
            r.rotation(board);
        }
        return 0;
    }
}
