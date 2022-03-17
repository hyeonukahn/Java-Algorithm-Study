import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_15683_감시_2 {
	static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];
		ArrayList<int[]> cctvList = new ArrayList<>();
		int zerocnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0 && board[i][j] < 6) {
					cctvList.add(new int[] { i, j, board[i][j] });
				} else {
					zerocnt++;
				}
			}
		}

		Collections.sort(cctvList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return -(o1[2] - o2[2]);
			}
		});

		sol(0, zerocnt, n, m, cctvList, board);

		System.out.println(ans);
		br.close();
	}

	static int returnZerocnt(int n, int m, int[][] board) {
		int countzero = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0)
					countzero++;
			}
		}
		return countzero;
	}

	static void sol(int cur, int zerocnt, int n, int m, ArrayList<int[]> cctvList, int[][] board) {
		if (cur == cctvList.size()) {
			int countzero = returnZerocnt(n, m, board);
			if (countzero < ans) {
				ans = countzero;
			}
			return;
		}

		int x, y, d;

		switch (cctvList.get(cur)[2]) {
		case 5:
			x = cctvList.get(cur)[0];
			y = cctvList.get(cur)[1];
			d = 0;
			while (d < 4) {
				int mx = x + dx[d];
				int my = y + dy[d];
				if (0 <= mx && mx < n && 0 <= my && my < m && board[mx][my] != 6) {
					board[mx][my] = 7;
					x = mx;
					y = my;
				} else {
					x = cctvList.get(cur)[0];
					y = cctvList.get(cur)[1];
					d++;
				}
			}
			sol(cur + 1, zerocnt, n, m, cctvList, board);
			break;

		case 2:
			x = cctvList.get(cur)[0];
			y = cctvList.get(cur)[1];
			for (int dirc = 0; dirc < 2; dirc++) {
				d = dirc;
				int[][] copyboard = new int[n][m];
				for (int k = 0; k < n; k++) {
					System.arraycopy(board[k], 0, copyboard[k], 0, m);
//					copyboard[k] = board[k].clone();
				}

				while (d < 4) {
					int mx = x + dx[d];
					int my = y + dy[d];
					if (0 <= mx && mx < n && 0 <= my && my < m && copyboard[mx][my] != 6) {
						copyboard[mx][my] = 7;
						x = mx;
						y = my;
					} else {
						x = cctvList.get(cur)[0];
						y = cctvList.get(cur)[1];
						d += 2;
					}
				}
				sol(cur + 1, zerocnt, n, m, cctvList, copyboard);
				x = cctvList.get(cur)[0];
				y = cctvList.get(cur)[1];
			}
			break;

		case 1:
			x = cctvList.get(cur)[0];
			y = cctvList.get(cur)[1];
			for (int dirc = 0; dirc < 4; dirc++) {
				d = dirc;
				int[][] copyboard = new int[n][m];
				for (int k = 0; k < n; k++) {
					System.arraycopy(board[k], 0, copyboard[k], 0, m);
//					copyboard[k] = board[k].clone();
				}

				while (true) {
					int mx = x + dx[d];
					int my = y + dy[d];
					if (0 <= mx && mx < n && 0 <= my && my < m && copyboard[mx][my] != 6) {
						copyboard[mx][my] = 7;
						x = mx;
						y = my;
					} else {
						break;
					}
				}

				sol(cur + 1, zerocnt, n, m, cctvList, copyboard);
				x = cctvList.get(cur)[0];
				y = cctvList.get(cur)[1];
			}
			break;
		case 3:
			x = cctvList.get(cur)[0];
			y = cctvList.get(cur)[1];
			for (int dirc = 0; dirc < 4; dirc++) {
				d = dirc;
				int[][] copyboard = new int[n][m];
				for (int k = 0; k < n; k++) {
					System.arraycopy(board[k], 0, copyboard[k], 0, m);
//					copyboard[k] = board[k].clone();
				}

				while (d - dirc < 2) {
					int mx = x + dx[d % 4];
					int my = y + dy[d % 4];
					if (0 <= mx && mx < n && 0 <= my && my < m && copyboard[mx][my] != 6) {
						copyboard[mx][my] = 7;
						x = mx;
						y = my;
					} else {
						x = cctvList.get(cur)[0];
						y = cctvList.get(cur)[1];
						d++;
					}
				}
				sol(cur + 1, zerocnt, n, m, cctvList, copyboard);
				x = cctvList.get(cur)[0];
				y = cctvList.get(cur)[1];
			}
			break;
		case 4:
			x = cctvList.get(cur)[0];
			y = cctvList.get(cur)[1];
			for (int dirc = 0; dirc < 4; dirc++) {
				d = dirc;
				int[][] copyboard = new int[n][m];
				for (int k = 0; k < n; k++) {
					System.arraycopy(board[k], 0, copyboard[k], 0, m);
//					copyboard[k] = board[k].clone();
				}

				while (d - dirc < 3) {
					int mx = x + dx[d % 4];
					int my = y + dy[d % 4];
					if (0 <= mx && mx < n && 0 <= my && my < m && copyboard[mx][my] != 6) {
						copyboard[mx][my] = 7;
						x = mx;
						y = my;
					} else {
						x = cctvList.get(cur)[0];
						y = cctvList.get(cur)[1];
						d++;
					}
				}
				sol(cur + 1, zerocnt, n, m, cctvList, copyboard);
				x = cctvList.get(cur)[0];
				y = cctvList.get(cur)[1];
			}
			break;
		}
	}
}
