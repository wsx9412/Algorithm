
import java.util.LinkedList;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		int[][] price;
		int[] weight;
		int money;
		LinkedList<Integer> waiting;
		Scanner sc = new Scanner(System.in);
		int T,n,m,car;
		T= sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			money = 0;
			waiting = new LinkedList<>();
			n = sc.nextInt();
			price = new int[n][2];
			m = sc.nextInt();
			weight = new int[m];
			for(int i = 0; i < n; i++) {
				price[i][0] = sc.nextInt();
			}
			
			for(int i = 0; i < m; i++) {
				weight[i] = sc.nextInt();
			}
			for(int i = 0; i < m*2; i++) {
				car = sc.nextInt();
				if(car > 0) {
					waiting.add(car);
				}else {
					for(int k = 0; k < n; k++) {
						if(price[k][1] == car * -1) {
							money += price[k][0] * weight[price[k][1]-1];	
							price[k][1] = 0;	
							break;
						}
					}
				}
				if(!waiting.isEmpty()) {
					for(int k = 0; k < n; k++) {
						if(price[k][1] == 0) {
							price[k][1] = waiting.poll();		
							break;
						}
					}
				}
				if(i == m * 2 -1)
					System.out.println("#" + test_case + " " + money);
			}

		}
	}
}