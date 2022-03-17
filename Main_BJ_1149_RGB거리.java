import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] houseCost = new int[n][3];
		int[][] costDp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				houseCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cur = 0;
		costDp[cur][0] = houseCost[0][0];
		costDp[cur][1] = houseCost[0][1];
		costDp[cur][2] = houseCost[0][2];
		for (cur = 1; cur < n; cur++) {
			costDp[cur][0] += Math.min(costDp[cur-1][1], costDp[cur-1][2])+houseCost[cur][0];
			costDp[cur][1] += Math.min(costDp[cur-1][0], costDp[cur-1][2])+houseCost[cur][1];
			costDp[cur][2] += Math.min(costDp[cur-1][0], costDp[cur-1][1])+houseCost[cur][2];
		}
		cur--;
		System.out.println(Math.min(Math.min(costDp[cur][0], costDp[cur][1]), costDp[cur][2]));
		
		br.close();
	}
}
