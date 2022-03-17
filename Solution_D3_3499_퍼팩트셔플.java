import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼팩트셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = Integer.parseInt(br.readLine());
		Queue<String> q1;
		Queue<String> q2;
		
		
		for (int tc = 1; tc <= tc_n; tc++) {
			q1 = new ArrayDeque<>();
			q2 = new ArrayDeque<>();
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < (n+1)/2; i++) {
				q1.add(st.nextToken());
			}
			while(st.hasMoreTokens()) {
				q2.add(st.nextToken());
			}
			
//			while(st.hasMoreTokens()) {
//				q1.add(st.nextToken());
//				if(st.hasMoreTokens()) {
//					q2.add(st.nextToken());
//				}
//			}
			sb.append("#"+tc+" ");
			
//			System.out.println(q1);
//			System.out.println(q2);
			
			while(!(q2.isEmpty())) {
				sb.append(q1.poll()+" ");
				sb.append(q2.poll()+" ");
			}
			
			if(!(q1.isEmpty())) {
				sb.append(q1.poll()+" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
