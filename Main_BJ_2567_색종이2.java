import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2567_색종이2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dowhaghi = new int[103][103];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x+1; j <= x+10; j++) {
				for (int j2 = y+1; j2 <= y+10; j2++) {
//					if((j == x || j == x+10-1 || j2==y||j2==y+10-1) && dowhaghi[j][j2] == 0) {
//						dowhaghi[j][j2] = 1;
//					} else {
//						dowhaghi[j][j2] = 2;
//					}
					dowhaghi[j][j2] = 1;
				}
			}
		}
		
//		for (int i = 0; i < dowhaghi.length; i++) {
//			System.out.println(Arrays.toString(dowhaghi[i]));
//		}
		
		int cnt = 0;
		for (int i = 1; i <= 101; i++) {
			for (int j = 1; j <= 101; j++) {
				if(dowhaghi[i][j] == 1) { 
						if(dowhaghi[i][j-1] == 0) cnt++;
						if(dowhaghi[i-1][j] == 0) cnt++;
						if(dowhaghi[i+1][j] == 0) cnt++;
						if(dowhaghi[i][j+1] == 0) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}

}
