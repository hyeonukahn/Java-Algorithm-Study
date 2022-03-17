import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산_유효성_검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc_n = 10;
		char[] treeArr;
		int chk;
		
		for (int tc = 1; tc <= tc_n; tc++) {
			chk = 1;
			int n = Integer.parseInt(br.readLine());
			treeArr = new char[n+1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				treeArr[i+1] = st.nextToken().charAt(0); 
			}
			int half = n/2;
			
			for (int i = 1; i <= half; i++) {
				if('0' <= treeArr[i] && treeArr[i] <='9') {
					chk = 0;
					break;
				}
			}
			for (int i = half+1; i <= n; i++) {
				if(!('0' <= treeArr[i] && treeArr[i] <='9')) {
					chk = 0;
					break;
				}
			}
			
			sb.append("#").append(tc);
			sb.append(" ").append(chk);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
