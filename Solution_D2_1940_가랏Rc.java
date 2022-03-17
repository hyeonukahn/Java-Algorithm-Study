import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1940_가랏Rc {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc_n = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= tc_n; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int ans = 0;
			int velocity = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int comm = Integer.parseInt(st.nextToken());
				
				switch(comm) {
				case 0:
					break;
				case 1:
					velocity += Integer.parseInt(st.nextToken());
					break;
					
				case 2:
					velocity -= Integer.parseInt(st.nextToken());
					if(velocity<0) {
						velocity = 0;
					}
					break;
				}
				ans += velocity;
				
			}
			
			sb.append("#"+tc);
			sb.append(" "+ans);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();		
	}
}
