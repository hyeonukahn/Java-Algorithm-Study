import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_아기상어_성공 {
	
	static class Fish implements Comparable<Fish>{
		int size;
		int x;
		int y;
		public Fish(int size, int x, int y) {
			this.size = size;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "fish [size=" + size + ", x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Fish o) {
			if(x == o.x) return y - o.y;
			return x-o.x;
		}
		
	}
	
	static int[] dx = {-1, 0, 0, 1}; //상좌
	static int[] dy = {0, -1, 1, 0};
	
	static int[][] board;
	static int sharkeat;
	static int sharkx, sharky;
	static int ans = 0;
	static ArrayList<Fish> canEat;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		sharkeat = 0;
		int sharksize = 2;
		
		ArrayList[] fishList = new ArrayList[7];
		for (int i = 1; i <= 6; i++) {
			fishList[i] = new ArrayList<Fish>();
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 9) {
//					board[i][j] = 0;
					sharkx = i;
					sharky = j;
				} else if(board[i][j]>0) {
					fishList[board[i][j]].add(new Fish(board[i][j], i, j));
				}
			}
		}
//		System.out.println(sharkx+" "+sharky);
//		System.out.println(Arrays.toString(fishList));
		
		canEat = new ArrayList<>();
		canEat.addAll(fishList[1]);
		Collections.sort(canEat);
		
		while(!canEat.isEmpty()) {
//			System.out.println(ans+" "+sharksize);
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
//			System.out.println();
			
			boolean bfssuccess = bfs(sharksize, n);
			
			if(sharkeat >= sharksize && sharksize <= 6) {
				sharksize++;
				canEat.addAll(fishList[sharksize-1]);
				Collections.sort(canEat);
				sharkeat = 0;
			}
			
			
			if(!bfssuccess) {
				break;
			}
		}
		
		System.out.println(ans);		
		br.close();
	}
	
	static boolean bfs(int sharksize, int n) {
		Queue<Integer> xque = new ArrayDeque<>();
		Queue<Integer> yque = new ArrayDeque<>();
		int[][] visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			visited[i] = board[i].clone();
		}
		xque.add(sharkx);
		yque.add(sharky);
		visited[sharkx][sharky] = 9;
		int dist=Integer.MAX_VALUE;
		boolean findfish = false;
		
		ArrayList<Fish> inFish = new ArrayList<>();
		int idx = -1;
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;

		while(!xque.isEmpty()) {
			int x = xque.poll();
			int y = yque.poll();

			if(dist < visited[x][y]-9) {
				continue;
			}
			
			for (int i = 0; i < canEat.size(); i++) {
				if(canEat.get(i).x == x && canEat.get(i).y == y) {
					dist = visited[x][y] - 9;
					findfish = true;
					
					if(minx > x) {
						idx = i;
						minx = x;
						miny = y;
					} else if(minx == x && miny > y) {
						idx = i;
						minx = x;
						miny = y;
					}
					
					break;
				}
			}
			
			
			for (int d = 0; d < dx.length; d++) {
				int mx = x+dx[d];
				int my = y+dy[d];
				
				if(0 <= mx && mx < n && 0 <= my && my < n && visited[mx][my] < 9) {
					if(sharksize < visited[mx][my]) {
						continue;
					} else {
						visited[mx][my] = visited[x][y]+1;
						xque.add(mx);						
						yque.add(my);						
					}
				}
			}
		}
		
		if(findfish) {
			ans += dist;
			board[sharkx][sharky] = 0;
			sharkx = canEat.get(idx).x;
			sharky = canEat.get(idx).y;
			board[sharkx][sharky] = 9;
			sharkeat++;
			canEat.remove(idx);
			
		}
		return findfish;
	}
}
