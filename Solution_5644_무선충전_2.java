import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5644_무선충전_2 {
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	
	static class AP_Info implements Comparable<AP_Info>{
		int x, y;
		int cover;
		int power; 
		public AP_Info(int y, int x, int cover, int power) {
			super();
			this.x = x;	this.y = y;
			this.cover = cover;
			this.power = power;
		}
		@Override
		public int compareTo(AP_Info o) {
			return -(this.power - o.power);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = Integer.parseInt(br.readLine());
		
		int[] moveA; int[] moveB;
		AP_Info[] apList;
		
		for (int tc = 1; tc <= tc_n; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int bc_N = Integer.parseInt(st.nextToken());
			
			moveA = new int[m+1]; moveB = new int[m+1];
			apList = new AP_Info[bc_N+1];
			int[][][] coverMap = new int[12][12][2];
			int ax = 1;	int ay = 1;
			int bx = 10; int by = 10;
			int sumA = 0; int sumB = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= bc_N; i++) {
				st = new StringTokenizer(br.readLine());
				apList[i] = new AP_Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(apList,1,apList.length);
			apList[0] = new AP_Info(-1, -1, -1, 0);
			
			for (int i = 1; i <= bc_N; i++) {
				for (int j = 1; j <= 10; j++) {
					for (int j2 = 1; j2 <= 10; j2++) {
						if(Math.abs(apList[i].x-j)+Math.abs(apList[i].y-j2) <= apList[i].cover) {
							if(coverMap[j][j2][0] == 0) coverMap[j][j2][0] = i;
							else if(coverMap[j][j2][0] != 0 && coverMap[j][j2][1] == 0) coverMap[j][j2][1] = i;
						}
					}
				}
			}

			for (int i = 0; i <= m; i++) {
				ax += dx[moveA[i]];	ay += dy[moveA[i]];
				bx += dx[moveB[i]];	by += dy[moveB[i]];
				if(coverMap[ax][ay][0] != coverMap[bx][by][0]) {
					sumA += apList[coverMap[ax][ay][0]].power;
					sumB += apList[coverMap[bx][by][0]].power;
				} else {
					sumA += apList[coverMap[ax][ay][0]].power;
					sumB += Math.max(apList[coverMap[ax][ay][1]].power, apList[coverMap[bx][by][1]].power);
				}
			}
			sb.append("#"+tc).append(" "+(sumA+sumB)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
