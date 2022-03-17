import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17471_게리맨더링 {
	static ArrayList<Integer>[] adjList;
	static int ans;
	static int[] popul;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		popul = new int[n+1];
		adjList = new ArrayList[n+1];
		ans = Integer.MAX_VALUE;
		
		for (int i = 1; i <= n ; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<>();
		}
		
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int aN = Integer.parseInt(st.nextToken());
			for (int j = 0; j < aN; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		select(1, 0, n);
		
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);		
		br.close();
	}
	
	static void select(int cnt, int flag, int n) {
		if(cnt > n) {
			
			if(flag == 0 || flag == (1 << (n+1)) - 2) {
				return;
			}
			
			boolean[] selectedPoll = bfs(flag, n);
			boolean[] noselectedPoll = bfs((~flag), n);
			
			int sumsel = 0;
			int sumnosel = 0;
			for (int i = 1; i <= n; i++) {
				if(selectedPoll[i]) {
					sumsel += popul[i];
				} else if(noselectedPoll[i]){
					sumnosel += popul[i];
				} else {
					return;
				}
			}
			
			int res = Math.abs(sumnosel-sumsel);
			
			if(res < ans) {
				ans = res;
			}
			return;
		}
		
		select(cnt+1, flag, n);
		select(cnt+1, (flag | 1 << cnt), n);
	}
	
	static boolean[] bfs(int flag, int n) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] isvisited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			if((flag & 1 << i) != 0) {
				q.add(i);
				isvisited[i] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for (Integer to : adjList[x]) {
				//110011
				if(!isvisited[to] && (flag & 1 << to) != 0) {
					isvisited[to] = true;
					q.add(to);
				}
			}
		}
		
		
		return isvisited;
	}
	
}
