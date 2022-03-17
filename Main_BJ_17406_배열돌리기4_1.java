import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17406_배열돌리기4_1 {
	
	static int[][] comArr;
	static int[][] ordercomArr;
	static boolean[] isSelcom;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] numArr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) numArr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		comArr = new int[k][3];
		ordercomArr = new int[k][3];
		isSelcom = new boolean[k];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) comArr[i][j] = Integer.parseInt(st.nextToken())-1;				
										comArr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		findOrder(0, k, n, m, numArr);
		
		sb.append(ans).append("\n");
		System.out.println(sb);
		br.close();
	}
	
	static void findOrder(int cnt, int k, int n, int m, int[][] numArr) {
		if(cnt == k) {
			int[][] changeArr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) 
					changeArr[i][j] = numArr[i][j];
			}
			
			for (int i = 0; i < k; i++) 
				changeArr = rotateArr(ordercomArr[i][0], ordercomArr[i][1], ordercomArr[i][2], changeArr);
			
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) sum += changeArr[i][j];
				if(sum < ans) ans = sum;
			}
			return;
		}
		
		for (int i = 0; i < k; i++) {
			if(isSelcom[i]) continue;
			
			ordercomArr[cnt] = comArr[i];
			
			isSelcom[i] = true;
			findOrder(cnt+1, k, n, m, numArr);
			isSelcom[i] = false;
		}
				
	}
	
	static int[][] rotateArr(int r, int c, int s, int[][] numArr) {
		int[][] changeArr = numArr;
		
		int endp = s;
		int startr = r-s;
		int startc = c-s;
		for (int i = 0; i < s; i++) {
			int d = 0;
			int x = startr;
			int y = startc;
			int startval = changeArr[x][y];
			while(d<4) {
				if(startr <= x+dx[d] && x+dx[d] <= startr+endp*2 && startc <= y+dy[d] && y+dy[d] <= startc+endp*2) {
					changeArr[x][y] = changeArr[x+dx[d]][y+dy[d]];
					x = x+dx[d];
					y = y+dy[d];
				} else d++;
			}
			changeArr[startr][startc+1] = startval;
			
			endp--;
			startr++;
			startc++;
		}
		return changeArr;
	}
}
