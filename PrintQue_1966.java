import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrintQue_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc_N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int n, m;
		Queue<Integer> pQue;
		int max;
		boolean b= true;
		int printed;
		int cnt;
		
		for (int tc = 0; tc < tc_N; tc++) {
			cnt = 0;
//			pQue = new LinkedList<>();
			pQue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for (int doc = 0; doc < n; doc++) {
				pQue.add(Integer.parseInt(st.nextToken()));
			}

			max = Collections.max(pQue);
			while(b) {
				printed = pQue.poll();
				if(printed<max) {
					if(m == 0) {
						m = pQue.size();
					}
					else {
						m--;
					}
					pQue.add(printed);
				}
				else {
					cnt++;
					if(m == 0) {
						break;
					}
					else {
						m--;
					}
					max = Collections.max(pQue);
				}
			}
//			System.out.println(cnt);
			sb.append(cnt+"\n");
			
		}
		System.out.println(sb);
		br.close();
	}
}
