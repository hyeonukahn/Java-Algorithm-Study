import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7576_토마토_2 {

	static class TomatoP { // 익은 토마토의 좌표를 저장하기 위한 클래스 선언
		int x, y; // x,y 좌표
		int dist; // 거리

		public TomatoP(int x, int y) {
			this.x = x;
			this.y = y;
			dist = 0;
		}

		public TomatoP(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int[][] board;
	static int[] dx = { -1, 0, 1, 0 }; // 상좌하우 순으로 탐색
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// 입력 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		ArrayList<TomatoP> maturedTomato = new ArrayList<>();
		int ans = 0;

		// 토마토 상자정보 입력, 익은 토마토는 list에 저장한다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					maturedTomato.add(new TomatoP(i, j));
				}
			}
		}

		// 입력end

		//bfs를 거친 후 토마토가 모두 익는데 며칠이 걸리는지 리턴
		ans = bfs(n, m, maturedTomato);

		// 출력
		System.out.println(ans);
		br.close();
	}

	public static int bfs(int n, int m, ArrayList<TomatoP> maturedTomato) {
		//bfs 탐색
		//초기 큐에 처음에 익은 토마토의 위치를 넣는다.
		//board(토마토 상자) 자체를 visited보드로 활용한다.
		Queue<TomatoP> que = new ArrayDeque<>();
		for (TomatoP tomato : maturedTomato) {
			que.add(tomato);
		}
		
		//최대 값 저장을 위한 변수
		int maxcnt = 0;

		//bfs 탐색
		while (!que.isEmpty()) {
			TomatoP p = que.poll();
			
			//사방탐색
			for (int d = 0; d < dx.length; d++) {
				int mx = p.x + dx[d];
				int my = p.y + dy[d];
				//경계선인지 확인 + 안익은 토마토인지 확인
				if (0 <= mx && mx < n && 0 <= my && my < m && board[mx][my] == 0) {
					board[mx][my] = 1;
					
					//최대 거리 저장
					if (maxcnt < p.dist + 1) {
						maxcnt = p.dist + 1;
					}
					//받아온 거리+1 한후 큐에 더하기
					que.add(new TomatoP(mx, my, p.dist + 1));
				}
			}
		}

		// 만약 안익은 토마토가 남아있다면 -1
		outer:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					maxcnt = -1;
					break outer;
				}
			}
		}

		//답 리턴
		return maxcnt;
	}

}
