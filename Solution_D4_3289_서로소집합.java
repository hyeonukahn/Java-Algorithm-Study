import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	static int[] parents;
	
	public static void makeSet(int n) {
		parents = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a]= findSet(parents[a]);
	}
	
	public static void union(int a, int b, int ctrl) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(ctrl == 1) {
			if(aRoot == bRoot) {
				sb.append("1");
			}
			else {
				sb.append("0");
			}
		}
		
		if(ctrl == 0) {
			parents[bRoot] = aRoot;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc_n = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= tc_n; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			makeSet(n);
			
			sb.append("#"+tc);
			sb.append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int comnum = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b, comnum);
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
