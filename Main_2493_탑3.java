import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2493_탑3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] towers = new int[n+1];
		
		int[] ans = new int[n+1];
		int h;
		
		Deque<int[]> towerStack = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		towers[0] = Integer.MAX_VALUE;
		
		
		for (int i = 1; i < n+1; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
			int[] tmp = {towers[i], i};
			if(towerStack.isEmpty() || towerStack.peekLast()[0] > towers[i]) {
				towerStack.add(tmp);
				ans[i] = towerStack.peekLast()[1]-1;
				
			}
			else{
				h = towers[i];
				while(towerStack.peekLast()[0]<h) {
					towerStack.pollLast();
					if(towerStack.isEmpty()) break;
				}
				if(towerStack.isEmpty()) ans[i] = 0;
				else ans[i] = towerStack.peekLast()[1];
				towerStack.add(tmp);
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			sb.append(ans[i]+" ");
		}
		bw.write(sb.toString());
//		System.out.println(sb);
		bw.flush();
		bw.close();
		br.close();		
	}

}
