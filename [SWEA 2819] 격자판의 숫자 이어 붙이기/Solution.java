
import java.util.HashSet;
import java.util.Scanner;

class Solution {
	static HashSet<String> list;

	public static void main(String args[]) throws Exception {
		Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		sc.nextLine();
		String[][] board;
		for (int T = 1; T <= TestCase; T++) {
			list = new HashSet<>();
			board = new String[4][4];
			for (int i = 0; i < 4; i++) {
				String line = sc.nextLine();
				board[i] = line.split(" ");
			}
			sol.travelBoard(board);
			System.out.println("#" + T + " " + list.size());
		}
	}

	public void travelBoard(String[][] board) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				moveBoard(i, j, "", board);
			}
		}
	}

	public void moveBoard(int x, int y, String str, String[][] board) {
		str += board[x][y];
		if (str.length() == 7) {
			if (!list.contains(str))
				list.add(str);
		}

		else {
			if (x > 0) {
				moveBoard(x - 1, y, str, board);
			}
			if (x < 3) {
				moveBoard(x + 1, y, str, board);
			}
			if (y > 0) {
				moveBoard(x, y - 1, str, board);
			}
			if (y < 3) {
				moveBoard(x, y + 1, str, board);
			}
		}
	}
}
