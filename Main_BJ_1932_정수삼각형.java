import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1932_정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] trisource = new int[i+1];
			int cnt = 0;
			while(st.hasMoreTokens()) {
				trisource[cnt++] = Integer.parseInt(st.nextToken());
			}
			triangle[i] = trisource;
		}
		
//		for (int[] is : triangle) {
//			System.out.println(Arrays.toString(is));
//		}
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if(j==0) {
					triangle[i][j] += triangle[i-1][j];
				} else if(j == triangle[i].length-1) {
					triangle[i][j] += triangle[i-1][j-1];
				} else {
					triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < triangle[n-1].length; i++) {
			if(max < triangle[n-1][i]) {
				max = triangle[n-1][i];
			}
		}
		System.out.println(max);
		
		br.close();
	}
}
