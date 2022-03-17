import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tmp, cnt;
		int tc_n = 10;
		boolean b = true;
		Queue<Integer> passwordQue = new ArrayDeque<>();
		for (int tc = 1; tc <= tc_n; tc++) {
			cnt = 0;
			passwordQue.clear();
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				passwordQue.add(Integer.parseInt(st.nextToken()));
			}
			
			while(b) {
				tmp = passwordQue.poll();
				tmp -= cnt%5+1;
				if(tmp <= 0) {
					passwordQue.add(0);
					break;
				}
				else {
					passwordQue.add(tmp);
					cnt++;
				}
			}
			
			sb.append("#"+tc+" ");
			for (Integer i : passwordQue) {
				sb.append(i+" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}
}
